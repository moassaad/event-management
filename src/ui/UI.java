package ui;

public class UI {
    public String banner() {
        return """
             __  __ ____    _____                     
            |  \\/  |  _ \\  |_   _|__  __ _ _ __ ___  
            | |\\/| | |_) |   | |/ _ \\/ _` | '_ ` _ \\ 
            | |  | |  _ <    | |  __/ (_| | | | | | | 
            |_|  |_|_| \\_\\   |_|\\___|\\__,_|_| |_| |_|
                        
                        MR TEAM
            """;
    }
    public String title(){
        return """
                ----------------------------
                    Event Management
                ----------------------------
                Welcome dear, please enter number of credits.
                e.g ~# 5 // you can use five operations and exit program.
                """;
    }
    public String view(){
        return """
                0- Change Credits
                1- Add member
                - List members
                - Create event
                - Register member to event
                - Give points
                - Show leaderboard
                7- Exit
                """;
    }
}
