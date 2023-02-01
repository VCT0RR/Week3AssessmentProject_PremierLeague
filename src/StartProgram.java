/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Jan 30, 2023
 */

import java.util.List;
import java.util.Scanner;

import controller.ListClubHelper;
import model.ListClub;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListClubHelper lch = new ListClubHelper();

		private static void addAClub() {
			// TODO Auto-generated method stub
			System.out.print("Enter a City: ");
			String city = in.nextLine();
			System.out.print("Enter an Club: ");
			String club = in.nextLine();
			System.out.print("Enter a Team Manager: ");
			String teamManager = in.nextLine();
			System.out.print("Enter the Football Team Rank: ");
			int footballRanking = in.nextInt();
			ListClub toAdd = new ListClub(city, club, teamManager, footballRanking);
			lch.insertClub(toAdd);

		}

		private static void deleteAClub() {
			// TODO Auto-generated method stub
			System.out.print("Enter the city to delete: ");
			String city = in.nextLine();
			System.out.print("Enter the club to delete: ");
			String club = in.nextLine();
			System.out.print("Enter the team manager to delete: ");
			String teamManager = in.nextLine();
			System.out.print("Enter the football team rank to delete: ");
			int footballRanking = in.nextInt();
			
			ListClub toDelete = new ListClub(city, club, teamManager, footballRanking);
			lch.deleteClub(toDelete);

		}

		private static void editAClub() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by City");
			System.out.println("2 : Search by Club");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListClub> foundClubs;
			if (searchBy == 1) {
				System.out.print("Enter the city name: ");
				String cityName = in.nextLine();
				foundClubs = lch.searchForClubByCity(cityName);
			}
			else {
				System.out.print("Enter the club name: ");
				String clubName = in.nextLine();
				foundClubs = lch.searchForClubByClub(clubName);
				

			}

			if (!foundClubs.isEmpty()) {
				System.out.println("Found Results.");
				for (ListClub l : foundClubs) {
					System.out.println(l.getId() + " : " + l.getClub());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListClub toEdit = lch.searchForClubById(idToEdit);
				System.out.println("Retrieved " + toEdit.getClub() + " from " + toEdit.getCity());
				System.out.println("1 : Update City");
				System.out.println("2 : Update Club");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New City: ");
					String newCity = in.nextLine();
					toEdit.setCity(newCity);
				} else if (update == 2) {
					System.out.print("New Club: ");
					String newClub = in.nextLine();
					toEdit.setClub(newClub);
				}

				lch.updateClub(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Premier League Clubs List! ---");
			while (goAgain) {
				System.out.println("*  Select a club:");
				System.out.println("*  1 -- Add a club");
				System.out.println("*  2 -- Edit a club");
				System.out.println("*  3 -- Delete a club");
				System.out.println("*  4 -- View all clubs");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAClub();
				} else if (selection == 2) {
					editAClub();
				} else if (selection == 3) {
					deleteAClub();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lch.cleanUp();
					System.out.println("---Thank you. Goodbye!---");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListClub> allClubs = lch.showAllClubs();
			for(ListClub singleClub : allClubs) {
				System.out.println(singleClub.returnClubDetails());
			}

		}

	}
