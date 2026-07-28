import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        // ========================================================
        // [Day 1] 기본 제어문 복습 코드
        // ========================================================
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

        // ========================================================
        // [Day 2] 객체지향 캡슐화 일기
        // ========================================================
        System.out.println("\n====================================================");
        System.out.println("2일차 객체지향 시작");

        // 오늘 날짜로 일기 객체 생성
        Diary day2 = new Diary(LocalDate.now());

        // 캡슐화된 메서드를 통해 안전하게 오늘 데이터 입력
        day2.setJapaneseStudy("히라가나 1시간 반 동안 집중 완료!");
        day2.setJavaStudy("여자친구 AI 툴 관련 자바 백엔드 에러 분석(경로/확장자 오류) 멘토링 완료");
        day2.setFeeling("실제 에러를 추적해서 설계하고 가르쳐 주니까 개발이 100배 더 재밌다.");

        // 일기장 출력 메서드 호출
        day2.printDailyLog();
    }
}

class Diary {
    private LocalDate date;
    private String japaneseStudy;
    private String javaStudy;
    private String feeling;

    public Diary(LocalDate date) {
        this.date = date;
    }

    public void setJapaneseStudy(String japaneseStudy) {
        this.japaneseStudy = japaneseStudy;
    }

    public void setJavaStudy(String javaStudy) {
        this.javaStudy = javaStudy;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public void printDailyLog() {
        System.out.println("📅 일자: " + this.date);
        System.out.println("🇯🇵 일본어: " + this.japaneseStudy);
        System.out.println("💻 자바/백엔드: " + this.javaStudy);
        System.out.println("💭 느낀점: " + this.feeling);
        System.out.println("====================================================");
        System.out.println("[SYSTEM] 2일 차 연속 약속한 공부 완료!");
    }
}