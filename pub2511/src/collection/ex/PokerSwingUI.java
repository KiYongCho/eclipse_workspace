package collection.ex;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PokerSwingUI.java
 * - Card / Player / PokerRule 로직을 그대로 활용하는 Swing UI 데모
 * - 기능: 5명 플레이어에게 7장씩 딜 -> 각 플레이어 족보 판정 결과 표시 + 로그 출력
 */
public class PokerSwingUI extends JFrame {

    // ===== UI 구성요소 =====
    private final JButton dealButton = new JButton("새 게임(딜)");
    private final JButton exitButton = new JButton("종료");
    private final JLabel statusLabel = new JLabel("준비됨");
    private final JTextArea logArea = new JTextArea(10, 60);

    private final List<PlayerPanel> playerPanels = new ArrayList<>();

    // ===== 게임 설정 =====
    private static final int PLAYER_COUNT = 5;
    private static final int CARDS_PER_PLAYER = 7;
    private static final List<String> SHAPES = Arrays.asList("♠️", "♦️", "♥️", "♣️");

    public PokerSwingUI() {
        super("Poker Game UI (Swing) - 7 Cards / 5 Players");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(680, 980));
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(12, 12));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(12, 12, 12, 12));

        add(buildTopBar(), BorderLayout.NORTH);
        add(buildCenterPlayers(), BorderLayout.CENTER);
        add(buildBottomLog(), BorderLayout.SOUTH);

        wireEvents();
        appendLog("UI 초기화 완료");
    }

    // ----------------------------
    // UI Layout Builders
    // ----------------------------
    private JComponent buildTopBar() {
        JPanel top = new JPanel(new BorderLayout(12, 12));

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        left.add(dealButton);
        left.add(exitButton);

        statusLabel.setFont(statusLabel.getFont().deriveFont(Font.BOLD, 14f));
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        right.add(statusLabel);

        top.add(left, BorderLayout.WEST);
        top.add(right, BorderLayout.EAST);

        return top;
    }

    private JComponent buildCenterPlayers() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        for (int i = 1; i <= PLAYER_COUNT; i++) {
            PlayerPanel pp = new PlayerPanel("Player " + i);
            playerPanels.add(pp);
            center.add(pp);
            center.add(Box.createVerticalStrut(10));
        }

        JScrollPane sp = new JScrollPane(center);
        sp.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "플레이어 보드",
                TitledBorder.LEFT, TitledBorder.TOP
        ));
        return sp;
    }

    private JComponent buildBottomLog() {
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);

        JScrollPane sp = new JScrollPane(logArea);
        sp.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "로그",
                TitledBorder.LEFT, TitledBorder.TOP
        ));
        return sp;
    }

    // ----------------------------
    // Event Wiring
    // ----------------------------
    private void wireEvents() {
        dealButton.addActionListener(e -> dealNewGame());
        exitButton.addActionListener(e -> dispose());
    }

    // ----------------------------
    // Game Flow
    // ----------------------------
    private void dealNewGame() {
        try {
            setStatus("카드 생성/셔플/딜 진행 중...");
            appendLog("새 게임 시작");

            // 1) 플레이어 생성 (매 게임 새로 생성: 카운트맵 초기화 목적)
            List<Player> players = new ArrayList<>();
            for (int i = 1; i <= PLAYER_COUNT; i++) {
                players.add(new Player("Player " + i, new ArrayList<>()));
            }

            // 2) 52장 덱 생성
            List<Card> deck = new ArrayList<>();
            for (String shape : SHAPES) {
                for (int num = 2; num < 15; num++) {
                    deck.add(new Card(num, shape));
                }
            }

            // 3) 셔플
            Collections.shuffle(deck);

            // 4) 딜 (7장씩)
            for (int i = 0; i < players.size(); i++) {
                int from = i * CARDS_PER_PLAYER;
                int to = from + CARDS_PER_PLAYER;
                players.get(i).setCardList(new ArrayList<>(deck.subList(from, to)));
            }

            // 5) 숫자/무늬 카운트맵 업데이트 (PokerMain 로직 그대로)
            for (Player p : players) {
                for (Card c : p.getCardList()) {
                    p.getNumCountMap().put(c.getNum(), p.getNumCountMap().get(c.getNum()) + 1);
                    p.getShapeCountMap().put(c.getShape(), p.getShapeCountMap().get(c.getShape()) + 1);
                }
            }

            // 6) UI 업데이트
            for (int i = 0; i < PLAYER_COUNT; i++) {
                Player p = players.get(i);
                String result = evaluateHand(p);

                playerPanels.get(i).setPlayer(p.getName());
                playerPanels.get(i).setCards(p.getCardList());
                playerPanels.get(i).setResult(result);

                appendLog(p.getName() + " => " + p.getCardList() + " " + result);
            }

            setStatus("완료 - " + nowStr());
        } catch (Exception ex) {
            setStatus("오류 발생");
            appendLog("ERROR: " + ex.getClass().getSimpleName() + " - " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                    "게임 진행 중 오류가 발생했습니다.\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private String evaluateHand(Player player) {
        // PokerMain.printResult와 동일한 우선순위
        if (PokerRule.isRoyalStraightFlush(player)) return "[로얄 스트레이트 플러시]";
        else if (PokerRule.isStraightFlush(player)) return "[스트레이트 플러시]";
        else if (PokerRule.isFourCard(player)) return "[포카드]";
        else if (PokerRule.isFullHouse(player)) return "[풀하우스]";
        else if (PokerRule.isFlush(player)) return "[플러시]";
        else if (PokerRule.isStraight(player)) return "[스트레이트]";
        else if (PokerRule.isTriple(player)) return "[트리플]";
        else if (PokerRule.isTwoPair(player)) return "[투 페어]";
        else if (PokerRule.isOnePair(player)) return "[원 페어]";
        else return "[족보 없음]";
    }

    // ----------------------------
    // Utils
    // ----------------------------
    private void setStatus(String msg) {
        statusLabel.setText(msg);
    }

    private void appendLog(String msg) {
        logArea.append("[" + nowStr() + "] " + msg + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    private static String nowStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // ----------------------------
    // Player Panel (UI Component)
    // ----------------------------
    private static class PlayerPanel extends JPanel {
        private final JLabel nameLabel = new JLabel();
        private final JPanel cardsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        private final JLabel resultLabel = new JLabel("");

        PlayerPanel(String playerName) {
            setLayout(new BorderLayout(12, 12));
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEtchedBorder(),
                    new EmptyBorder(10, 10, 10, 10)
            ));

            nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 16f));
            resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 16f));

            JPanel top = new JPanel(new BorderLayout(12, 12));
            top.add(nameLabel, BorderLayout.WEST);
            top.add(resultLabel, BorderLayout.EAST);

            add(top, BorderLayout.NORTH);
            add(cardsPanel, BorderLayout.CENTER);

            setPlayer(playerName);
            setResult("[대기]");
            setCards(new ArrayList<>());
        }

        void setPlayer(String name) {
            nameLabel.setText(name);
        }

        void setResult(String result) {
            resultLabel.setText(result);
        }

        void setCards(List<Card> cards) {
            cardsPanel.removeAll();

            if (cards == null || cards.isEmpty()) {
                JLabel empty = new JLabel("카드 없음");
                empty.setForeground(Color.DARK_GRAY);
                cardsPanel.add(empty);
            } else {
                for (Card c : cards) {
                    cardsPanel.add(createCardLabel(c));
                }
            }

            revalidate();
            repaint();
        }

        private JComponent createCardLabel(Card card) {
            JLabel lbl = new JLabel(card.toString());
            lbl.setOpaque(true);
            lbl.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(180, 180, 180)),
                    new EmptyBorder(8, 10, 8, 10)
            ));

            // 무늬(하트/다이아) 색 구분(가독성 목적)
            String s = card.getShape();
            if ("♥️".equals(s) || "♦️".equals(s)) {
                lbl.setForeground(new Color(160, 0, 0));
            } else {
                lbl.setForeground(new Color(0, 0, 0));
            }

            lbl.setBackground(new Color(245, 245, 245));
            lbl.setFont(lbl.getFont().deriveFont(Font.BOLD, 18f));
            return lbl;
        }
    }

    // ----------------------------
    // Entry Point
    // ----------------------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PokerSwingUI().setVisible(true));
    }
}
