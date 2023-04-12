package login;

public class UserView {
    private static UserRepository repository;
    public static UserView loginView;

    static {
        loginView= new UserView();
        repository  = new UserRepository();

    }

    public  UserView() {
    }

    public void inputUserinfo() {
        while(true) {
            System.out.println("        [ 메 인 화 면 ]");
            System.out.println("1. 로그인하기");
            System.out.println("2. 회원가입하기");
            switch (Utility.input("번호 입력 >> ")) {
                case "1":
                    this.loginStart();
                    break;
                case "2":
                    userSys.UserView.start();
                    break;
                default:
                    System.out.println("메뉴 번호로 입력해주세요");
            }
        }
    }

    public void loginStart() {
        String inputId = Utility.input("# 아이디 입력 : ");
        String inputPwd = Utility.input("# 비밀번호 입력 : ");
        UserRepository.loadSaveFile();
        repository.loginValidate(inputId,inputPwd);
        try {
            repository.loginValidate(inputId, inputPwd);
        } catch (LoginValidateException var4) {
            System.out.println(var4.getMessage());
        }

    }

    public void joinStart() {
        repository.loadSaveFile();
        inputUserinfo();

    }

}
