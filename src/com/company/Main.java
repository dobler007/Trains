package com.company;


import RailroadCars.Restaurant;
import RailroadCars.PassangerCar;
import RailroadCars.PostOffice;
import RailroadCars.BaggageMail;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void menu(){
        System.out.println("1: create Locomotive" + "\n" +
                         "2: show all TrainSets" + "\n" +
                         "3: add a railway car to the Locomotive" + "\n" +
                         "4: find the distance between stations" + "\n" +
                         "5: Start the trainset's route (make it move)" + "\n" +
                         "6: Stop" + "\n" +
                         "0: Quit                  ");
    }
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Station> stations = new ArrayList<>();
        Station stockholm = new Station("Stockholm", null, 0); stations.add(stockholm);
        Station copenhagen = new Station("Copenhagen", stockholm, 600); stations.add(copenhagen);
        stockholm.setNextStation(copenhagen);
        Station hamburg = new Station("Hamburg", copenhagen, 750); stations.add(hamburg);
        copenhagen.setNextStation(hamburg);
        Station amsterdam = new Station("Amsterdam", hamburg, 500);stations.add(amsterdam);
        hamburg.setNextStation(amsterdam);
        Station brussels = new Station("Brussels", amsterdam, 200);stations.add(brussels);
        amsterdam.setNextStation(brussels);
        Station paris = new Station("Paris", brussels, 300);stations.add(paris);
        brussels.setNextStation(paris);
        Station geneva = new Station("Geneva", paris, 500);stations.add(geneva);
        paris.setNextStation(geneva);
        Station milan = new Station("Milan", geneva, 300);stations.add(milan);
        geneva.setNextStation(milan);
        Station venice = new Station("Venice", milan, 350);stations.add(venice);
        milan.setNextStation(venice);
        Station vienna = new Station("Vienna", venice, 500);stations.add(vienna);
        venice.setNextStation(vienna);
        Station budapest = new Station("Budapest", vienna, 300);stations.add(budapest);
        vienna.setNextStation(budapest);
        Station belgrade = new Station("Belgrade", budapest, 400);stations.add(belgrade);
        budapest.setNextStation(belgrade);
        Station sofia = new Station("Sofia", belgrade, 500);stations.add(sofia);
        belgrade.setNextStation(sofia);
        Station istanbul = new Station("Istanbul", sofia, 600);stations.add(istanbul);
        sofia.setNextStation(istanbul);
        Station thessaloniki = new Station("Thessaloniki", istanbul, 400);stations.add(thessaloniki);
        istanbul.setNextStation(thessaloniki);

        //Trainsets*************************************************************************************************
        ArrayList<TrainSet> trainSets = new ArrayList<>();
        Restaurant restaurant1 = new Restaurant(800, 800, "Gordon Ramsey", 1);
        Locomotive loc1 = new Locomotive("Daur", 90, 120000);
        TrainSet ts1 = new TrainSet(loc1, 15, 5,stockholm, geneva); trainSets.add(ts1);
        ts1.addRailCar(restaurant1);


        Scanner scan = new Scanner(System.in);
        int option;
        do {
            menu();
            option = scan.nextInt();
            switch (option) {
                case 1: {
                    Locomotive temp = new Locomotive();
                    System.out.println("Give it a name: ");
                    scan.nextLine();
                    temp.name = scan.nextLine();
                    System.out.println(temp.name + "'s max speed is: ");
                    temp.speed = scan.nextDouble();
                    System.out.println(temp.name + "'s max weight transporting is: ");
                    temp.max_weight = scan.nextDouble();
                    System.out.println("How many Railroad Cars can it carry ?");
                    int maxCars = scan.nextInt();
                    System.out.println("How many Railroad Cars can it connect to it's electrical grid ?");
                    int maxElec = scan.nextInt();
                    System.out.println("What is the Home station of the TrainsSet ? aka the locomotive");
                    for (int i = 0; i < stations.size(); i++) {
                        System.out.println(i + ": " + stations.get(i));
                    }
                    int home = scan.nextInt();
                    System.out.println("What is the destination of the TrainsSet ? aka the locomotive");
                    int dest = scan.nextInt();

                    TrainSet temp1 = new TrainSet(temp, maxCars, maxElec, stations.get(home), stations.get(dest));
                    trainSets.add(temp1);
                    break;
                }
                case 2: {
                    for (int i = 0; i <= trainSets.size() - 1; i++) {
                        System.out.println(trainSets.get(i));
                    }
                    break;
                }
                case 3: {
                    System.out.println("Which Trainset shall get the Railroad ?");
                    for (int i = 0; i < trainSets.size(); i++) {
                        System.out.println(i + ": " + trainSets.get(i));
                    }
                    int trainSetIndex = scan.nextInt();

                    System.out.println("Which type of railroad car would you like to add ?");
                    System.out.println("1:  passenger railroad that requires connection to the locomotive’s electrical grid" + "\n" +
                            "2:  railroad post office that requires connection to the locomotive’s electrical grid" + "\n" +
                            "3:  railroad baggage and mail car that requires connection to the locomotive’s electrical grid" + "\n" +
                            "4:  railroad restaurant car that requires connection to the locomotive’s electrical grid" + "\n" +
                            "5:  basic railroad freight car that requires connection to the locomotive’s electrical grid" + "\n" +
                            "6:  heavy railroad freight car that requires connection to the locomotive’s electrical grid" + "\n" +
                            "7:  basic freight refrigerated railroad car that requires connection to the locomotive’s electrical grid" + "\n" +
                            "8:  basic freight railroad car for liquid materials" + "\n" +
                            "9:  basic freight railroad car for gaseous material" + "\n" +
                            "10: heavy freigth railroad car for explosive" + "\n" +
                            "11: heavy freigth railroad car for toxic materials" + "\n" +
                            "12: heavy freigth railroad car for liquid, toxic material" + "\n"
                    );
                    int carType = scan.nextInt();

                    switch (carType) {
                        case 1:
                            System.out.println("Whats the net weight of the car ?");
                            int netWeight = scan.nextInt();
                            System.out.println("Whats the type of the car ? 'first class, economy, business class' ");
                            scan.nextLine();
                            String type = scan.nextLine();
                            System.out.println("whats the seats capacity ?");
                            int seatsCap = scan.nextInt();
                            PassangerCar passengerCar = new PassangerCar(netWeight, netWeight, seatsCap, type);
                            trainSets.get(trainSetIndex).addRailCar(passengerCar);
                            break;
                        case 2: {
                            System.out.println("Whats the net weight of the car ?");
                            netWeight = scan.nextInt();
                            System.out.println("how much mails in kg can it carry ?");
                            int mailCap = scan.nextInt();
                            PostOffice postOfficeCar = new PostOffice(netWeight, netWeight, mailCap);
                            trainSets.get(trainSetIndex).addRailCar(postOfficeCar);
                            break;
                        }
                        case 3: {
                            System.out.println("Whats the net weight of the car ?");
                            netWeight = scan.nextInt();
                            System.out.println("how much baggage and mail can it carry in kgs ?");
                            int maxAmount = scan.nextInt();
                            BaggageMail baggageMail = new BaggageMail(netWeight, netWeight, maxAmount);
                            trainSets.get(trainSetIndex).addRailCar(baggageMail);
                            break;
                        }
                        case 4: {
                            System.out.println("Whats the net weight of the car ?");
                            netWeight = scan.nextInt();
                            System.out.println("whats the name of the Head Chef ?");
                            scan.nextLine();
                            String Chef = scan.nextLine();
                            System.out.println("How much staff does the railroad car have ? Staff can be hired or fired.");
                            int staff = scan.nextInt();
                            Restaurant restaurantCar = new Restaurant(netWeight, netWeight, Chef, staff);
                            trainSets.get(trainSetIndex).addRailCar(restaurantCar);
                            break;
                        }
                        /*
                        case 5: {
                            System.out.println("Whats the net weight of the car ?");
                            netWeight = scan.nextInt();
                            System.out.println("whats the name of the Head Chef ?");
                            scan.nextLine();
                            break;
                        }
                         */
                    }
                    break;
                }
                case 4: {
                    System.out.println("The distance between what stations would you like to know ? keep in mind that you can only look from less index to higher index");
                    for (int d = 0; d < stations.size(); d++) {
                        System.out.println(d + ": " + stations.get(d));
                    }
                    System.out.println("Enter the first station by it's index");
                    int first = scan.nextInt();
                    System.out.println("Now choose the second Station");
                    int second = scan.nextInt();
                    if (first > second) {
                        int temp = first;
                        first = second;
                        second = temp;
                    }
                    System.out.println(Station.tripDistance(stations.get(first), stations.get(second)));
                    break;
                }
                case 5: {
                    System.out.println("Which TrainSet shall start it's journey ?");
                    for (int t = 0; t < trainSets.size(); t++) {
                        System.out.println(t + ": " + trainSets.get(t));
                    }
                    int moveT = scan.nextInt();
                    Thread runnin = new Thread(trainSets.get(moveT));
                    runnin.start();
                    break;
                }
                case 6: {
                    System.out.println("Which TrainSet shall stop it's journey ?");
                    for (int t = 0; t < trainSets.size(); t++) {
                        System.out.println(t + ": " + trainSets.get(t));
                    }
                    int stopT = scan.nextInt();
                    trainSets.get(stopT).stopper();
                    break;
                }
                case 0: break;
                default: {
                    System.out.println("Please choose from the options that are presented");
                    break;
                }
            }
        } while (option != 0);
    }
}