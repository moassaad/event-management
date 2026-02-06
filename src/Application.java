import model.Event;
import model.Member;
import model.OfficerMember;
import model.RegularMember;
import service.RegistrationService;
import ui.EventUI;
import ui.MemberUI;
import ui.UI;

import java.util.Scanner;

public class Application {

    public static void start(){
        UI ui = new UI();
        MemberUI memberUi = new MemberUI();
        EventUI eventUi = new EventUI();
        Menu menu = new Menu();

        System.out.println(ui.banner());
        System.out.println(ui.title());
        Scanner input = new Scanner(System.in);
        System.out.print("Number of credits ~# ");
        int credits = input.nextInt();

        int start = 0;
        while (start < credits) {
            System.out.println(ui.view());
//            Scanner input = new Scanner(System.in);
            System.out.print("~# ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    try {

                        System.out.print(memberUi.choiceMemberType());
                        System.out.print("~# ");
                        int choiceType = input.nextInt();

                        System.out.print(memberUi.enterName());
                        System.out.print("~# ");
                        String name = input.next();

                        System.out.print(memberUi.enterEmail());
                        System.out.print("~# ");
                        String email = input.next();

                        menu.addMember(choiceType, name, email);

                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:
                    try{

                        System.out.println("-----------------------");
                        if (menu.listMember().isEmpty())
                        {
                            System.out.println("No Member Yet.");
                            break;
                        }

                        menu.listMembers().forEach(System.out::println);

                        System.out.println("-----------------------");
//                        menu.listMembers().forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try{

                        System.out.print(eventUi.enterTitle());
                        System.out.print("~# ");
                        String title = input.next();

                        System.out.print(eventUi.enterCapacity());
                        System.out.print("~# ");
                        int capacity = input.nextInt();

                        System.out.print(eventUi.enterType());
                        System.out.print("~# ");
                        String type = input.next();

                        menu.createEvent(title, capacity, type);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try{

                        System.out.println(eventUi.chooseEventNumber());
                        System.out.println("-----------------------");
                        if (menu.listEvent().isEmpty())
                        {
                            System.out.println("No Event Yet.");
                            break;
                        }

                        for(Event event: menu.listEvent())
                        {
                            System.out.println(event);
                        }

                        System.out.println("-----------------------");

                        System.out.print(eventUi.enterId());
                        System.out.print("~# ");
                        int eventId = input.nextInt();

                        Event event = menu.findEventById(eventId);

                        System.out.println(memberUi.chooseMemberNumber());
                        System.out.println("-----------------------");
                        if (menu.listMember().isEmpty())
                        {
                            System.out.println("No Member Yet.");
                            break;
                        }

                        for(Member member: menu.listMember())
                        {
                            System.out.println(member);
                        }

                        System.out.println("-----------------------");

                        System.out.print(memberUi.enterId());
                        System.out.print("~# ");
                        int memberId = input.nextInt();

                        Member member = menu.findMemberById(memberId);

                        RegistrationService registrationService = new RegistrationService();

                        registrationService.registerMember(member, event);


                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try{
                        System.out.println(memberUi.chooseMemberNumber());
                        System.out.println("-----------------------");
                        if (menu.listMember().isEmpty())
                        {
                            System.out.println("No Member Yet.");
                            break;
                        }

                        for(Member member: menu.listMember())
                        {
                            System.out.println(member);
                        }

                        System.out.println("-----------------------");

                        System.out.print(memberUi.enterId());
                        System.out.print("~# ");
                        int memberId = input.nextInt();

                        System.out.print(memberUi.enterPoint());
                        System.out.print("~# ");
                        double points = input.nextDouble();

                        Member member = menu.findMemberById(memberId);

                        if (member instanceof OfficerMember)
                        {
                            ((OfficerMember) member).updatePointsBuons(points);
                        }else if (member instanceof RegularMember){
                            member.updatePoints(points);
                        }


                        System.out.println("Update Points is Successfully");
                        System.out.println(member.toString());

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try{
                        System.out.println(memberUi.leaderboard());
                        System.out.println("-----------------------");

                        for(Member member: menu.listMemberOrderByPointsDesc())
                        {
                            System.out.println(member);
                        }

                        System.out.println("-----------------------");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Bye :)");
                    return;
//                    break;

                default:
                    System.out.println("Invalid choice! Please choose between 1 and 7.");
            }
            start++;
        }
    }
}
