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

        // 2026년 7월 28일로 일기 객체 생성
        Diary day2 = new Diary(LocalDate.of(2026, 7, 28));

        // 캡슐화된 메서드를 통해 안전하게 오늘 데이터 입력
        day2.setJapaneseStudy("히라가나 1시간 반 동안 집중 완료!");
        day2.setJavaStudy("여자친구 AI 툴 관련 자바 백엔드 에러 분석(경로/확장자 오류) 멘토링 완료");
        day2.setFeeling("실제 에러를 추적해서 설계하고 가르쳐 주니까 개발이 100배 더 재밌다.");

        // 일기장 출력 메서드 호출
        day2.printDailyLog();

        // ========================================================
        // [Day 3] 상속과 오버라이딩
        // ========================================================
        System.out.println("\n====================================================");
        System.out.println("3일차 객체지향 시작");

        // 부모 클래스의 기능을 물려받은 자식 클래스 객체 생성 (26.07.29일 기준)
        SecureDiary day3 = new SecureDiary(LocalDate.of(2026,7,29));

        // 부모에게 물려받은 메서드 그대로 사용
        day3.setNday("3");
        day3.setJapaneseStudy("히라가나 가타카나 암기 및 독음 연습");
        day3.setJavaStudy("자바 객체지향에서 상속과 오버라이딩 문법 복습, 아무래도 날짜가 전부 localdate.now()로 설정해두니 " +
                "오늘 날짜로 모든 날짜가 작성되어서 문제 해결 위해서 실제 날짜로 수정 ");
        day3.setFeeling("코드가 상속을 통해 깔끔하게 분리되는 걸 보니 백엔드 구조가 눈에 들어온다.");

        // 자식 클래스에만 새로 추가된 보안 취약점 방어 데이터 입력
        day3.setSecurityConcept("웹 보안 기초 - SQL Injection 공격 방어를 위한 PreparedStatement 활용법 공부");

        // 오버라이딩된 출력 메서드 호출
        day3.printDailyLog();


        // ========================================================
        // [Day 4] 다형성 일기
        // ========================================================
        System.out.println("\n====================================================");
        System.out.println("🛡️ [4일차 객체지향 다형성 시작] 🛡️");

        // [복습] 다형성 적용
        // 부모 타입의 참조 변수로 자식 객체를 참조할 수 있다.
        Diary day4 = new SecureDiary(LocalDate.of(2026, 7, 30));

        // 부모 타입이라도 실제 객체가 자식이므로, 오버라이딩된 자식의 Setter와 메서드가 동작.
        if (day4 instanceof SecureDiary) {
            SecureDiary secureDay4 = (SecureDiary) day4;
            secureDay4.setNday("4");
            secureDay4.setJapaneseStudy("바쁜 약속 일정 속에서도 자투리 시간 활용해 일어 단어 복습");
            secureDay4.setJavaStudy("다형성과 타입 형변환");
            secureDay4.setSecurityConcept("웹 보안 실무 - 인증/인가 메커니즘과 JWT 토큰의 구조 이해");
            secureDay4.setFeeling("피곤한 약속 끝내고 와서 밤늦게라도 마저 해야지 ");
        }

        // 다형성을 통해 부모 메서드를 호출해도, 실제 자식의 업그레이드된 출력문이 실행됨!
        day4.printDailyLog();

        // ========================================================
        // [Day 5] 추상화 일기 코드
        // ========================================================

        System.out.println("\n====================================================");
        System.out.println("🧱 [5일차 객체지향 추상화 시작] 🧱");

        // 추상 클래스(WeeklyReview)를 구체화한 자식 객체 생성
        WeeklyReview myWeek = new FinalReview();

        // 일주일 요약 데이터 입력
        myWeek.setSummary("월요일을 시작으로 금요일까지 단 하루도 깨지지 않고 5일 연속 기상 및 공부 성공");
        myWeek.setNextWeekPlan("다음 주에는 자바 기본기를 바탕으로 진짜 Spring Boot 웹 백엔드 서버 구축을 시작해볼 생각");
        myWeek.setNday("5");

        // 추상 메서드로 강제 구현된 핵심 성과 출력 호출
        myWeek.printWeeklyReport();


    }
}

class Diary {
    protected  LocalDate date;
    protected  String japaneseStudy;
    protected  String javaStudy;
    protected  String feeling;
    protected  String nday;

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

    public void setNday(String nday){this.nday = nday; }

    public void printDailyLog() {
        System.out.println("📅 일자: " + this.date);
        System.out.println("🇯🇵 일본어: " + this.japaneseStudy);
        System.out.println("💻 자바/백엔드: " + this.javaStudy);
        System.out.println("💭 느낀점: " + this.feeling);
        System.out.println("====================================================");
        System.out.println("[SYSTEM] 2일 차 연속 약속한 공부 완료!");
    }
}

//자식 클래스 SecureDiary
class SecureDiary extends Diary{
    //자식 클래스의 전용 확장 데이터
    private String securityConcept;

    //생성자 : 부모 생성자 호출 (super키워드)
    public SecureDiary(LocalDate date){
        super(date);
    }

    // 자식 전용 setter
    public void setSecurityConcept(String securityConcept){
        this.securityConcept = securityConcept;
    }

    //오버라이딩 = 메서드 재정의
    //부모의 printDailyLog 기능을 업그레이드 해서 덮어쓰기
    @Override
    public void printDailyLog() {
        System.out.println("🔐 [SECURITY BACKEND DIARY DAY"+ this.nday+"] 🔐");
        System.out.println("📅 일자: " + this.date);
        System.out.println("🇯🇵 일본어: " + this.japaneseStudy);
        System.out.println("💻 자바/백엔드: " + this.javaStudy);
        System.out.println("🛡️ 보안 취약점 대책: " + this.securityConcept); // 확장된 출력
        System.out.println("💭 느낀점: " + this.feeling);
        System.out.println("====================================================");
        System.out.println("[SYSTEM] 상속(Inheritance) 구조 적용 완료!");
    }
}

// 추상클래스
abstract class WeeklyReview {
    protected String nDay;
    protected String summary;
    protected String nextWeekPlan;

    // 💡 공통 Setter 메서드 탑재
    public void setNday(String nDay) { this.nDay = nDay; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setNextWeekPlan(String nextWeekPlan) { this.nextWeekPlan = nextWeekPlan; }

    // 추상 메서드: 자식 클래스에서 반드시 강제로 오버라이딩하여 구현
    public abstract void printWeeklyReport();
}

// 구체 클래스: 추상 클래스를 상속받아 진짜 기능을 구현함
class FinalReview extends WeeklyReview {
    @Override
    public void printWeeklyReport() {
        System.out.println("🔐 [SECURITY BACKEND DIARY DAY"+ this.nDay+"] 🔐");
        System.out.println("🟩 이번 주 총평: " + this.summary);
        System.out.println("🎯 다음 주 계획: " + this.nextWeekPlan);
        System.out.println("====================================================");
        System.out.println("[SYSTEM] 자바 객체지향 복습 완료");
    }
}
