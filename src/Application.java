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
            System.out.print("~# ");
            int choice = input.nextInt();
            switch (choice) {
                case 0:
                    try{
                        System.out.println("-----------------------");
                        System.out.println("Your credits is " + (credits - start));
                        System.out.println("-----------------------");
                        System.out.print("Number of credits ~# ");
                        int newCredits = input.nextInt();
                        if(newCredits <= 0){
                            throw new Exception("You can't add negative number or zero.");
                        }
                        credits += newCredits;

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
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

                        System.out.println("Successfully");
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

                        menu.listMember().forEach(System.out::println);

                        System.out.println("-----------------------");
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
                        System.out.println("Successfully");
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

                        menu.listEvent().forEach(System.out::println);

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

                        menu.listMember().forEach(System.out::println);

                        System.out.println("-----------------------");

                        System.out.print(memberUi.enterId());
                        System.out.print("~# ");
                        int memberId = input.nextInt();

                        Member member = menu.findMemberById(memberId);

                        RegistrationService registrationService = new RegistrationService();

                        registrationService.registerMember(member, event);

                        System.out.println("Successfully");

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

                        menu.listMember().forEach(System.out::println);

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


                        System.out.println(member.toString());
                        System.out.println("Successfully");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try{
                        System.out.println(memberUi.leaderboard());
                        System.out.println("-----------------------");

                        menu.listMemberOrderByPointsDesc().forEach(System.out::println);

                        System.out.println("-----------------------");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Bye :)");
                    start = credits;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 7.");
            }
            start++;
            System.out.println("Bye :)");
        }
        System.out.println("Your credits is over, Bye :)");
    }
}
