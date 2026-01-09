package collection.ex;

// 컬렉션(Map, List 등) 사용을 위한 import
import java.util.*;

public class PokerRule {

    // 1) 최상위 족보 판정 메서드
    //    - "같은 무늬 안에서" 로열/스트레이트가 되는지 확인

    // 로얄스트레이트플러시: 같은 무늬에서 10,J,Q,K,A(10~14)
    public static boolean isRoyalStraightFlush(Player player) {
        // player가 가진 카드 7장을 넘겨서 "무늬별로 나눈 후 로열 스트레이트 여부"를 검사
        return hasRoyalStraightFlush(player.getCardList());
    }

    // 스트레이트플러시: 같은 무늬에서 연속 5장(로얄 제외)
    public static boolean isStraightFlush(Player player) {
        // 같은 무늬 내에서 스트레이트가 되는지 검사
        // 단, 로열 스트레이트 플러시는 스트레이트 플러시의 상위 족보이므로 제외(!isRoyalStraightFlush)
        return hasStraightFlush(player.getCardList()) && !isRoyalStraightFlush(player);
    }

    // 2) 숫자/무늬 "카운트 맵" 기반 족보 판정

    // 포카드: 같은 숫자 4장
    public static boolean isFourCard(Player player) {
        // 숫자별 등장 횟수(numCountMap)의 모든 키(숫자)를 순회
        for (Integer k : player.getNumCountMap().keySet()) {
            // 어떤 숫자든 등장 횟수가 4면 포카드
            if (player.getNumCountMap().get(k) == 4) return true;
        }
        // 끝까지 없으면 false
        return false;
    }

    // 풀하우스: 트리플 + 페어(또는 트리플 2개)
    public static boolean isFullHouse(Player player) {
        // 트리플(3장짜리) 개수
        int t = numOfTriple(player);
        // 페어(2장짜리) 개수
        int p = numOfPair(player);

        // 트리플이 2개 이상이면 (예: 777 + 999) => 풀하우스 성립 가능
        // 트리플 1개 + 페어 1개 이상이면 => 일반적인 풀하우스
        return (t >= 2) || (t >= 1 && p >= 1);
    }

    // 플러시: 같은 무늬 5장 이상
    public static boolean isFlush(Player player) {
        // 무늬별 등장 횟수(shapeCountMap) 키(무늬)를 순회
        for (String s : player.getShapeCountMap().keySet()) {
            // 어떤 무늬든 5장 이상이면 플러시
            if (player.getShapeCountMap().get(s) >= 5) return true;
        }
        // 없으면 false
        return false;
    }

    // 스트레이트: 연속된 숫자 5개 이상 (순서 의존 제거)
    public static boolean isStraight(Player player) {
        // HashMap의 순서를 믿지 않고
        // boolean 배열(present[])로 존재 여부만 만들고 연속 5개를 스캔
        return hasStraightFromNumCountMap(player.getNumCountMap());
    }

    // 트리플: (페어 없이) 같은 숫자 3장
    public static boolean isTriple(Player player) {
        // 페어가 없고(numOfPair==0), 트리플이 정확히 1개면 트리플
        // (풀하우스 상황을 트리플로 잘못 잡지 않기 위해 페어가 없는 조건을 둠)
        return numOfPair(player) == 0 && numOfTriple(player) == 1;
    }

    // 투페어: 트리플 없이 페어가 2개 이상(3페어도 포함)
    public static boolean isTwoPair(Player player) {
        // 트리플이 없고(numOfTriple==0), 페어가 2개 이상이면 투페어
        // 3페어(예: 22, 55, 99)도 ">=2"라서 투페어로 포함됨 (룰 설계에 따라 OK)
        return numOfTriple(player) == 0 && numOfPair(player) >= 2;
    }

    // 원페어: 트리플 없이 페어 1개
    public static boolean isOnePair(Player player) {
        // 트리플 없고, 페어가 정확히 1개면 원페어
        return numOfTriple(player) == 0 && numOfPair(player) == 1;
    }

    // 3) 카운트 계산 유틸 (페어/트리플 개수 구하기)

    // 페어 수
    public static int numOfPair(Player player) {
        int count = 0; // 페어 개수 누적 변수

        // 숫자 카운트맵의 키(숫자)를 전부 순회
        for (Integer k : player.getNumCountMap().keySet()) {
            // 해당 숫자가 정확히 2번 등장하면 페어 1개
            if (player.getNumCountMap().get(k) == 2) count++;
        }
        return count; // 총 페어 개수 반환
    }

    // 트리플 수
    public static int numOfTriple(Player player) {
        int count = 0; // 트리플 개수 누적 변수

        // 숫자 카운트맵의 키(숫자) 순회
        for (Integer k : player.getNumCountMap().keySet()) {
            // 해당 숫자가 정확히 3번 등장하면 트리플 1개
            if (player.getNumCountMap().get(k) == 3) count++;
        }
        return count; // 총 트리플 개수 반환
    }

    // 로열 스트레이트(10~14) 여부
    public static boolean isRoyalStraight(Player player) {
        // 숫자 존재 여부를 boolean 배열로 변환
        boolean[] present = toPresenceArrayFromCounts(player.getNumCountMap());

        // 10,11,12,13,14(A)가 모두 존재하면 로열 스트레이트
        return present[10] && present[11] && present[12] && present[13] && present[14];
    }

    // 4) 로열 스트레이트 플러시 판정 (핵심: 무늬별로 따로 체크)

    private static boolean hasRoyalStraightFlush(List<Card> cards) {
        // 카드들을 무늬별로 그룹핑 (예: "♠" -> [♠2,♠A,...])
        Map<String, List<Card>> bySuit = groupBySuit(cards);

        // 각 무늬(스페이드/하트/다이아/클럽)를 순회
        for (String suit : bySuit.keySet()) {

            // 해당 무늬의 카드 리스트
            List<Card> suitCards = bySuit.get(suit);

            // 무늬 카드가 5장 미만이면 플러시 자체가 불가능하므로 skip
            if (suitCards.size() < 5) continue;

            // 해당 무늬 안에서 숫자 존재 여부를 boolean 배열로 만든다
            boolean[] present = toPresenceArrayFromCards(suitCards);

            // 10~A가 모두 존재하면 그 무늬에서 로열 스트레이트가 성립 -> 로열SF
            if (present[10] && present[11] && present[12] && present[13] && present[14]) {
                return true; // 즉시 true 반환
            }
        }

        // 어떤 무늬에서도 로열 스트레이트가 안 나오면 false
        return false;
    }

    // 5) 스트레이트 플러시 판정 (무늬별로 스트레이트 검사)

    private static boolean hasStraightFlush(List<Card> cards) {
        // 무늬별 카드 그룹 생성
        Map<String, List<Card>> bySuit = groupBySuit(cards);

        // 무늬별로 순회
        for (String suit : bySuit.keySet()) {

            // 해당 무늬 카드만 뽑은 리스트
            List<Card> suitCards = bySuit.get(suit);

            // 무늬 카드가 5장 미만이면 스트레이트 플러시 불가능 -> skip
            if (suitCards.size() < 5) continue;

            // 해당 무늬 안에서 숫자 존재 여부 배열 생성
            boolean[] present = toPresenceArrayFromCards(suitCards);

            // 그 무늬 안에서 연속 5개(스트레이트)가 있으면 스트레이트 플러시
            if (hasStraight(present)) return true;
        }

        // 어떤 무늬에서도 스트레이트가 안 나오면 false
        return false;
    }

    // 6) 카드 리스트를 "무늬별"로 묶는 함수

    private static Map<String, List<Card>> groupBySuit(List<Card> cards) {
        // 결과: 무늬(String) -> 그 무늬 카드 리스트
        Map<String, List<Card>> map = new HashMap<>();

        // 입력 카드들을 하나씩 순회
        for (Card c : cards) {
            // map에 해당 무늬 키가 없으면 새 ArrayList 생성 후 넣음
            // 있으면 기존 리스트를 가져와서 add 수행
            map.computeIfAbsent(c.getShape(), k -> new ArrayList<>()).add(c);
        }

        // 무늬별 그룹핑 결과 반환
        return map;
    }

    // 7) 숫자카운트맵 -> 스트레이트 존재 여부

    private static boolean hasStraightFromNumCountMap(Map<Integer, Integer> numCountMap) {
        // 숫자카운트맵을 boolean 존재배열로 변환
        boolean[] present = toPresenceArrayFromCounts(numCountMap);

        // 존재배열에서 연속 5개가 있는지 검사
        return hasStraight(present);
    }

    // 8) Map 기반 -> boolean 존재배열 변환

    // present[i] == i가 존재하면 true
    private static boolean[] toPresenceArrayFromCounts(Map<Integer, Integer> numCountMap) {
        // 0은 사용하지 않고 1~14 인덱스를 사용 (A=14)
        boolean[] present = new boolean[15];

        // 2~14까지 검사 (포커 숫자 범위)
        for (int n = 2; n <= 14; n++) {
            // 해당 숫자의 등장 횟수를 가져온다
            Integer cnt = numCountMap.get(n);

            // 1장 이상 존재하면 present[n] = true
            if (cnt != null && cnt >= 1) present[n] = true;
        }

        // A(14)가 있으면 A를 1로도 취급
        // 즉, A-2-3-4-5 (휠 스트레이트) 지원을 위한 트릭
        if (present[14]) present[1] = true;

        // 존재배열 반환
        return present;
    }

    // 카드 리스트 기반 -> boolean 존재배열 변환
    private static boolean[] toPresenceArrayFromCards(List<Card> cards) {
        // 0 unused, 1~14 사용
        boolean[] present = new boolean[15];

        // 해당 무늬 카드들에서 숫자만 추출하여 존재 여부 표시
        for (Card c : cards) {
            int n = c.getNum(); // 카드 숫자 (2~14)

            // 정상 범위면 존재 체크
            if (n >= 2 && n <= 14) present[n] = true;
        }

        // A(14)가 있으면 A를 1로도 취급 (A2345 지원)
        if (present[14]) present[1] = true;

        // 존재배열 반환
        return present;
    }

    // 9) 존재배열에서 스트레이트(연속 5개) 찾기

    // 연속 5개 이상 스캔
    private static boolean hasStraight(boolean[] present) {
        int run = 0; // 현재 연속으로 이어진 길이

        // 1~14까지 순서대로 검사
        for (int i = 1; i <= 14; i++) {
            // 해당 숫자가 존재하면 연속 길이 +1
            if (present[i]) {
                run++;

                // 연속 길이가 5 이상이면 스트레이트 성립
                if (run >= 5) return true;
            } else {
                // 끊기면 연속 길이 초기화
                run = 0;
            }
        }

        // 끝까지 5연속이 없으면 false
        return false;
    }
}
