public class App {
    public static void main(String[] args) throws Exception {
        try{
            Application.start();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
