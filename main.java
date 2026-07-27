public class Main {
    public static void main(String[] args){
        //(복습) 변수 선언과 데이터타입
        String name = "천기정";
        int codeStudyHours = 3;
        int japanStudyHours = 2;
        int totalHours = codeStudyHours + japanStudyHours;

        System.out.println("---오늘 하루 공부 시간 측정---");
        System.out.println("개발자 이름 :" + name);
        System.out.println("오늘 총 공부 시간 : " +totalHours+ "시간");

        //(복습) 조건문 활용하기(if-else)
        System.out.println("\n---멘탈 상태 점검---");
        if(totalHours >=5){
            System.out.println("결과 : 약속 지켰다! 공부 완료");
        }
        else{
            System.out.println("결과 : 아직 부족하다. 더 열심히 하자");
        }

        //(복습) 반복문 for문 활용해서 일주일 목표 출력하기
        System.out.println("\n---이번주 함 달려보자---");
        for(int i =1; i<=5;i++){
            System.out.println(("Day " + i + "깃허브 잔디 무조건 심어야지"));
        }

        String todayJapaneseWord = "パソコン (파소콘 = PC)";
        String optionMessage = "생각보다 일본어가 재밌어서 다행이다.";
        System.out.println("\n===========================================");
        System.out.println("[오전 일과] 일무따 1/2챕터 완료. " + optionMessage);
        System.out.println("[오후 일과] 인텔리제이 설치 및 자바 기본 제어문 복습 완료.");
        System.out.println("[보안/백엔드 다짐] 까먹은거도 많은데 오랜만에 자바 잡으니까 기억도 돌아오는거 같고 재밌다! 앞으로도 더 열심히 해보자");
        System.out.println("[SYSTEM] 스스로와의 약속 성공! 앞으로도 이렇게만 열심히 하자!");
        System.out.println("===========================================");
    }
}