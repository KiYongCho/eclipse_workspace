package collection.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
1. 플레이어는 이름과 카드들을 갖는다.
2. 카드는 숫자와 무늬를 갖는다.
3. 플레이어를 5명 만든다.
4. 카드를 52장 만든다.
5. 카드를 섞는다.
6. 카드를 7장씩 플레이어에게 나눠준다.
7. 플레이어가 가진 7장의 카드에서
   모양별 개수, 숫자별 개수를 추출해서 저장
8. 포커룰을 만든다.
9. 플레이어의 족보를 출력
*/

public class PokerMain {

	public static void main(String[] args) {

		// 플레이어를 5명 만든다
		List<Player> playerList = Arrays.asList(new Player("홍길동", Collections.EMPTY_LIST),
				new Player("이순신", Collections.EMPTY_LIST), new Player("강감찬", Collections.EMPTY_LIST),
				new Player("권율", Collections.EMPTY_LIST), new Player("최영", Collections.EMPTY_LIST));

		// 카드를 52장 만든다 (S2~S14, D2~D14, H2~H14, C2~C14)
		List<Card> totalCardList = new ArrayList<Card>();
		List<String> shapeList = Arrays.asList("♠️", "♦️", "♥️", "♣️");
		for (int i = 0; i < shapeList.size(); i++) {
			for (int j = 2; j < 15; j++) {
				totalCardList.add(new Card(j, shapeList.get(i)));
			}
		}

		// 카드를 섞자
		Collections.shuffle(totalCardList);

		// 플레이어들에게 7장씩 나눠준다
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).setCardList(totalCardList.subList(i * 7, (i * 7) + 7));
		}

		// 플레이어가 가진 7장 카드의 숫자, 무늬 카운팅
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			for (Card card : playerList.get(i).getCardList()) {
				player.getNumCountMap().put(card.getNum(), player.getNumCountMap().get(card.getNum()) + 1);
				player.getShapeCountMap().put(card.getShape(), player.getShapeCountMap().get(card.getShape()) + 1);
			}
		}

		playerList.stream().forEach(player -> {
			System.out.println(player);
			printResult(player);
		});

	} // main

	private static void printResult(Player player) {
		String resultStr = "";
		if (PokerRule.isRoyalStraightFlush(player))
			resultStr = "[로열스트레이트플러시]";
		else if (PokerRule.isStraightFlush(player))
			resultStr = "[스트레이트플러시]";
		else if (PokerRule.isFourCard(player))
			resultStr = "[포카드]";
		else if (PokerRule.isFullHouse(player))
			resultStr = "[풀하우스]";
		else if (PokerRule.isFlush(player))
			resultStr = "[플러시]";
		else if (PokerRule.isStraight(player))
			resultStr = "[스트레이트]";
		else if (PokerRule.isTriple(player))
			resultStr = "[트리플]";
		else if (PokerRule.isTwoPair(player))
			resultStr = "[투 페어]";
		else if (PokerRule.isOnePair(player))
			resultStr = "[원 페어]";
		else
			resultStr = "[족보 없음]";
		System.out.println(resultStr + "\n");
	}

} // class
