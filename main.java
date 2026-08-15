import java.time.LocalDate;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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


        // ========================================================
        // [다시 시작] 인터페이스를 활용
        // ========================================================
        System.out.println("\n====================================================");
        System.out.println("🔌 [복귀 완료 - 인터페이스 시작] 🔌");

        // 인터페이스 타입으로 객체 생성 (다형성 활용)
        LogManager myRecoveryLog = new RecoveryDiary(LocalDate.of(2026, 8, 5));

        // 데이터 출력 및 백업 시스템 가동
        myRecoveryLog.readLog();
        myRecoveryLog.backupToGithub();

        // ========================================================
        // [예외 처리] try-catch 문을 활용한 보안 방어막 빌드업!
        // ========================================================
        System.out.println("\n====================================================");
        System.out.println("🛡️ [에러 방어 - 예외 처리 빌드업 시작] 🛡️");

        // 의도적으로 에러를 발생시키기 위해, 내용을 비워둔 빈 일기장 생성
        SafeDiary errorLog = new SafeDiary(LocalDate.of(2026, 8, 6), null);

        // 에러가 날 수 있는 위험한 코드를 try 블록 안에 넣고 감시합니다.
        try {
            errorLog.runSecurePrint();
        } catch (NullPointerException e) {
            // 에러가 발생했을 때 프로그램이 터지지 않고 실행될 방어 코드
            System.out.println("[⚠️ SECURITY RISK DETECTED] 데이터 누락 에러 감지!");
            System.out.println("[방어 메커니즘 가동] 에러 원인: " + e.getMessage());
            System.out.println("[SYSTEM] 시스템 강제 종료를 막고 안전하게 복구했습니다.");
        } finally {
            // 에러 여부와 상관없이 무조건 마지막에 실행되는 블록
            System.out.println("====================================================");
            System.out.println("[SYSTEM] 8월 6일 예외 처리 실습 이후 처리 메시지 확인 완료");
            System.out.println("====================================================");
        }
        // ========================================================
        // [컬렉션 프레임워크] ArrayList를 활용한 다중 데이터 관리 및 복귀
        // ========================================================

        System.out.println("\n====================================");
        System.out.println("[복귀 했습니다 - 컬렉션 프레임워크 빌드업");

        //자바의 대표적인 동적 배열 ArrayList 생성 (여러 개의 일기를 한번에 관리)
        java.util.List<String> recoveryLogs = new java.util.ArrayList<>();

        //데이터 추가 (.add 메서드)
        recoveryLogs.add("1. 몸 아프고 바빠서 못채운 공백기 끝내기");
        recoveryLogs.add("2. 자바 필수 개념 arraylist 동적 배열 공부");
        recoveryLogs.add("3. 무너져도 잘해보자 돈관리도 시작");

        // 반복문을 활용해 모아둔 일기 출력
        System.out.println("🩹 [RECOVERY MULTI-LOG AT AUGUST 13] 🩹");
        for (String logItem : recoveryLogs) {
            System.out.println("-> " + logItem);
        }
        System.out.println("========================================================");
        System.out.println("[SYSTEM] ArrayList 구조 적용 및 8월 13일 일기 작성 완료");
        System.out.println(" ========================================================");

        // ========================================================
        // [파일 입출력 & 보안] 파일 저장 및 데이터 무결성(Integrity) 검증
        // ========================================================
        System.out.println("\n====================================================");
        System.out.println("💾 [영속성 확보 - 파일 입출력 및 데이터 무결성 검증 시작] 💾");

        String filePath = "secure_diary.txt";

        // 1. 파일 쓰기 (FileWriter와 try-with-resources 문법)
        // try 옆 괄호() 안에 객체를 생성하면, 작업이 끝난 후 자원(Resource)을 자동으로 닫아주어 메모리 누수를 방지합니다.
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            System.out.println("[SYSTEM] 일기 파일에 안전하게 데이터를 기록하는 중...");

            // ArrayList에 있던 내용을 파일로 저장합니다.
            for (String logItem : recoveryLogs) {
                writer.write(logItem + "\n");
            }
            System.out.println("[SUCCESS] 암호화 및 파일 저장 완료: " + filePath);

        } catch (java.io.IOException e) {
            System.out.println("[❌ SECURITY RISK] 파일 쓰기 중 시스템 에러 발생: " + e.getMessage());
        }

        // 2. 파일 읽기 및 악성 코드/변조 검증 (Data Validation)
        System.out.println("\n🔍 [검증 시스템 가동] 저장된 파일 읽기 및 무결성 검사 수행...");

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                // 🛡️ [보안 방어막] 입력값 검증 (Input Validation)
                // 만약 해커가 파일을 변조하여 시스템 명령어나 비정상적인 문자(예: 관리자 권한 탈취 시도)를 주입했다면?
                if (line.contains("DROP TABLE") || line.contains("sudo rm")) {
                    System.out.println("[🚨 CRITICAL WARNING] 라인 " + lineNumber + "에서 데이터 변조 및 공격 징후 감지!");
                    System.out.println("[ACTION] 변조된 데이터 출력을 차단하고 관리자에게 알립니다.");
                    break;
                }

                // 안전한 데이터만 화면에 출력합니다.
                System.out.println("[안전 확인 - Line " + lineNumber + "] " + line);
                lineNumber++;
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("[⚠️ ERROR] 일기 파일을 찾을 수 없습니다. 경로를 확인하세요.");
        } catch (java.io.IOException e) {
            System.out.println("[⚠️ ERROR] 파일 읽기 중 오류 발생: " + e.getMessage());
        }

        System.out.println("====================================================");
        System.out.println("[SYSTEM] 8월 14일 파일 입출력 및 보안 입력 검증 실습 완료");
        System.out.println("====================================================");


        // ========================================================
        // [백엔드 보안 최강화] AES 암호화 기반 파일 저장 및 복호화
        // ========================================================
        System.out.println("\n====================================================");
        System.out.println("🔐 [기밀성 최강화 - AES 암호화 일기장 시스템 가동] 🔐");

        String cryptoFilePath = "crypto_diary.txt";

        // 1. 데이터를 암호화하여 파일에 저장하기
        try (java.io.FileWriter writer = new java.io.FileWriter(cryptoFilePath)) {
            System.out.println("[SYSTEM] 일기 데이터를 AES 알고리즘으로 암호화하는 중");

            for (String logItem : recoveryLogs) {
                //  그냥 쓰지 않고, SecurityUtil을 통해 암호화한 후 저장
                String encryptedLine = SafeDiary.SecurityUtil.encrypt(logItem);
                writer.write(encryptedLine + "\n");
            }
            System.out.println("[SUCCESS] 암호화 파일 저장 완료: " + cryptoFilePath);
            System.out.println("[💡 팁] 인텔리제이 좌측에서 " + cryptoFilePath + " 파일을 열어 내용을 직접 확인해보세요!");

        } catch (java.io.IOException e) {
            System.out.println("[⚠️ ERROR] 파일 쓰기 실패: " + e.getMessage());
        }

        // 2. 암호화된 파일을 읽어와서 복호화하여 출력하기
        System.out.println("\n🔓 [복호화 시스템 가동] 암호화된 파일 복구 및 읽기 시작...");

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(cryptoFilePath))) {
            String encryptedLine;
            int lineNumber = 1;

            while ((encryptedLine = reader.readLine()) != null) {
                // 🛡️ [보안 방어막] 파일에서 읽은 외계어(암호문)를 다시 사람이 읽을 수 있게 복호화!
                String decryptedLine = SafeDiary.SecurityUtil.decrypt(encryptedLine);

                System.out.println("[안전 복호화 완료 - Line " + lineNumber + "] " + decryptedLine);
                lineNumber++;
            }

        } catch (java.io.IOException e) {
            System.out.println("[ERROR] 파일 읽기 또는 복호화 실패: " + e.getMessage());
        }

        System.out.println("====================================================");
        System.out.println("[SYSTEM] 오늘자 암호화 실습 종료");
        System.out.println("====================================================");

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

// 💡 인터페이스: 규격서 정의 (모든 메서드는 추상 메서드)
interface LogManager {
    void readLog();       // 일기 읽기 기능 강제
    void backupToGithub(); // 깃허브 백업 기능 강제
}

// 구체 클래스: 인터페이스를 구현(implements)함
class RecoveryDiary implements LogManager {
    private LocalDate date;

    public RecoveryDiary(LocalDate date) {
        this.date = date;
    }

    @Override
    public void readLog() {
        System.out.println("🩹 [RECOVERY DEVELOPER DIARY] 🩹");
        System.out.println("📅 복귀 일자: " + this.date);
        System.out.println("🟩 공부 내용: 몸 관리 잘하고 다시 복귀! 인터페이스 문법 복습 완료.");
        System.out.println("💭 오늘의 한줄: 한 번 비었다고 더 안할수는 없지! 열심히 해봅시다잉 다시");
    }

    @Override
    public void backupToGithub() {
        System.out.println("====================================================");
        System.out.println("[SYSTEM] GitHub Desktop 연동 확인 완료.");
        System.out.println("====================================================");
    }
}

// 구체 클래스: 예외 처리 테스트를 위한 보안 클래스
class SafeDiary {
    private LocalDate date;
    private String content;

    public SafeDiary(LocalDate date, String content) {
        this.date = date;
        this.content = content;
    }

    // 에러를 유발할 수 있는 위험한 메서드
    public void runSecurePrint() {
        System.out.println("📅 일자: " + this.date);

        // 💡 만약 content가 null(빈 값)이면, .length()를 호출하는 순간 에러가 발생
        if (this.content.length() == 0) {
            System.out.println("일기 내용이 비어 있습니다.");
        } else {
            System.out.println("📝 내용: " + this.content);
        }
    }


    public class SecurityUtil {

        // AES-256을 위한 32바이트(256비트) 비밀키
        // 실무에서는 환경변수나 Key Vault에 숨기지만, 우선 하드코딩 먼저 시도. 비밀키는 ai 통해서 작성
        private static final String SECRET_KEY = "S3cur3D1aryK3yF0rBack3ndStUdy!!?";
        private static final String ALGORITHM = "AES";

        // 평문을 암호문으로 바꾸는 메서드
        public static String encrypt(String plainText) {
            try {
                SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);

                byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
                // 암호화된 바이너리 데이터를 텍스트 파일에 쓰기 좋게 Base64 문자열로 변환합니다.
                return Base64.getEncoder().encodeToString(encryptedBytes);
            } catch (Exception e) {
                throw new RuntimeException("암호화 중 오류 발생: " + e.getMessage());
            }
        }

        // 암호문을 다시 평문으로 바꾸는 메서드
        public static String decrypt(String cipherText) {
            try {
                SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, keySpec);

                byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
                byte[] decryptedBytes = cipher.doFinal(decodedBytes);
                return new String(decryptedBytes, StandardCharsets.UTF_8);
            } catch (Exception e) {
                throw new RuntimeException("복호화 중 오류 발생. 키가 틀렸거나 데이터가 오염되었습니다. " + e.getMessage());
            }
        }
    }
}


