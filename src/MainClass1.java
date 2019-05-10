import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controller.AccountManager;
import Controller.CategoryManager;
import Controller.FinancialManager;
import Controller.IncomeManager;
import Controller.OutcomeManager;
import Controller.UserManager;
import Controller.Utils;
import Model.Account;
import Model.Category;
import Model.Income;
import Model.Outcome;
import Model.User;

public class MainClass1 {
	private static Scanner scanner = new Scanner(System.in);

	public static void showMenu() {
		int choice = 0;
		do {
			System.out.println("--------------------------------");
			System.out.println(
					String.format("Welcome %s to your Spendiser", UserManager.instance.getCurrentUser().getName()));

			System.out.println("Enter (1) to add Financial account");
			System.out.println("Enter (2) to Delete Financial account");
			System.out.println("Enter (3) to get your Financial balance");
			System.out.println("Enter (4) to insert an income ");
			System.out.println("Enter (5) to get all incomes ");
			System.out.println("Enter (6) to get incomes ");
			System.out.println("Enter (7) to insert an outcome ");
			System.out.println("Enter (8) to get outcomes ");
			System.out.println("Enter (9) to get all outcomes ");
			System.out.println("Enter (10) to show monthly statistics for outcome ");
			System.out.println("Enter (0) to logout");
			System.out.println("--------------------------------");

			choice = scanner.nextInt();

			switch (choice) {

			case 1: {
				System.out.println("Please enter your Financial account name");
				String Financialaccountname = scanner.next();
				Account ac = new Account(Financialaccountname, UserManager.instance.getCurrentUser().getU_ID());
				try {
					AccountManager.instance.insertAccount(ac);
					System.out.println("Your Financial account has been added successfully!..");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}

			case 2: {
				System.out.println("Accounts:\n");
				try {

					ArrayList<Account> accounts = AccountManager.instance.getAllAccounts();
					for (Account a : accounts) {
						System.out.println(String.format("%d- %s", a.getId(), a.getName()));

					}
					if (accounts.isEmpty() == true) {
						System.out.println("You have no accounts");
						break;
					} else {
						System.out.println("Enter the id of the account you want to delete ");
						int accountid = scanner.nextInt();
						try {
							ArrayList<Account> accounts1 = AccountManager.instance.getAllAccounts();
							for (Account a : accounts1) {
								if (accountid == a.getId()) {
									AccountManager.instance.deleteAccount(accountid);
									System.out.println("Your Financial account has been deleted successfully!..");
									break;
								}
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				break;
			}

			case 3: {
				double balance;
				try {
					balance = FinancialManager.instance.getBalance();
					System.out.println(String.format("Your financial balance is %.2f $", balance));

				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			}

			case 4: {
				try {
					System.out.println("Enter amount");
					double amount = scanner.nextDouble();

					System.out.println("write a description");
					String description = scanner.next();

					System.out.println("Enter the date of your income");
					String d = scanner.next();
					Date date = Utils.stringToDate(d);

					System.out.println("Choose your account by id");
					ArrayList<Account> accounts = AccountManager.instance.getAllAccounts();
					for (Account a : accounts) {
						System.out.println(String.format("%d- %s", a.getId(), a.getName()));
					}
					int aid = scanner.nextInt();

					Income income = new Income(amount, description, date, aid);
					IncomeManager.instance.insertIncome(income);
					System.out.println("Income added successfully!..");
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			}

			case 5: {

				ArrayList<Income> incomes;
				try {
					incomes = IncomeManager.instance.getAllIncomes();
					for (Income income : incomes) {
						System.out.println(String.format(
								"Income: Amount: %.3f $\t  Description:%s\t Date:%s\t  a_id:%d ", income.getAmount(),
								income.getDescription(), income.getFormatedDate(), income.getA_ID()));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}

			case 6: {
				try {
					System.out.println("Enter start date");
					String sd = scanner.next();
					Date sdate = Utils.stringToDate(sd);

					System.out.println("Enter Enddate date");
					String ed = scanner.next();
					Date edate = Utils.stringToDate(ed);

					System.out.println("Choose your account by id");
					ArrayList<Account> accounts = AccountManager.instance.getAllAccounts();
					for (Account a : accounts) {
						System.out.println(String.format("%d- %s", a.getId(), a.getName()));
					}
					int aid = scanner.nextInt();

					ArrayList<Income> incomes = IncomeManager.instance.getIncomes(aid, sdate, edate);
					for (Income income : incomes) {
						System.out.println(String.format(
								"Income: Amount: %.3f $\t  Description:%s\t Date:%s\t  a_id:%d  ", income.getAmount(),
								income.getDescription(), income.getFormatedDate(), income.getA_ID()));
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}

			case 7: {
				try {
					System.out.println("Enter amount");
					double amount = scanner.nextDouble();

					System.out.println("write a description");
					String description = scanner.next();

					System.out.println("Enter the date of your outcome");
					String d = scanner.next();
					Date date = Utils.stringToDate(d);

					System.out.println("Choose your category by id");
					ArrayList<Category> categories = CategoryManager.instance.getAllCategories();
					for (Category c : categories) {
						System.out.println(String.format("%d- %s", c.getId(), c.getName()));
					}
					int cid = scanner.nextInt();

					System.out.println("Choose your account by id");
					ArrayList<Account> accounts = AccountManager.instance.getAllAccounts();
					for (Account a : accounts) {
						System.out.println(String.format("%d- %s", a.getId(), a.getName()));
					}
					int aid = scanner.nextInt();

					Outcome o = new Outcome(amount, description, date, cid, aid);
					OutcomeManager.instance.insertOutcome(o);
					System.out.println("Outcome added successfully!..");
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			}

			case 8: {
				try {

					System.out.println("Choose your category by id");
					ArrayList<Category> categories = CategoryManager.instance.getAllCategories();
					for (Category c : categories) {
						System.out.println(String.format("%d- %s", c.getId(), c.getName()));
					}
					int cid = scanner.nextInt();

					System.out.println("Enter start date");
					String sd = scanner.next();
					Date sdate = Utils.stringToDate(sd);

					System.out.println("Enter End date date");
					String ed = scanner.next();
					Date edate = Utils.stringToDate(ed);

					System.out.println("Choose your account by id");
					ArrayList<Account> accounts = AccountManager.instance.getAllAccounts();
					for (Account a : accounts) {
						System.out.println(String.format("%d- %s", a.getId(), a.getName()));
					}
					int aid = scanner.nextInt();

					ArrayList<Outcome> outcomes = OutcomeManager.instance.getOutcomes(cid, aid, sdate, edate);
					for (Outcome outcome : outcomes) {
						System.out.println(String.format(
								"Outcome: Amount: %.3f $\t  Description:%s\t Date:%s\t  C_id:%d\t a_id:%d",
								outcome.getAmount(), outcome.getDescription(), outcome.getFormatedDate(),
								outcome.getC_id(), outcome.getA_id()));
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			case 9: {

				ArrayList<Outcome> outcomes;
				try {
					outcomes = OutcomeManager.instance.getAllOutcomes();
					for (Outcome outcome : outcomes) {
						System.out.println(String.format(
								"Outcome: Amount: %.3f $\t  Description:%s\t Date:%s\t  C_id:%d\t  a_id:%d",
								outcome.getAmount(), outcome.getDescription(), outcome.getFormatedDate(),
								outcome.getC_id(), outcome.getA_id()));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}

			case 10: {
				User u = UserManager.instance.getCurrentUser();
				try {
					if (UserManager.instance.checkPremium(u) == true) {
						System.out.println("Please enter month number");
						int month = scanner.nextInt();
						try {
							double Mstatics = FinancialManager.instance.TotalOutcomes(month);
							System.out.println("total monthly outcomes are " + Mstatics + " $");
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println("Enter (1) to get current month outcome ");
						int currentoutcome = scanner.nextInt();
						if (currentoutcome == 1) {
							System.out.println("Enter category by id to ");
							ArrayList<Category> categories = CategoryManager.instance.getAllCategories();
							for (Category c : categories) {
								System.out.println(String.format("%d- %s", c.getId(), c.getName()));
							}

							int cid = scanner.nextInt();

							ArrayList<Account> accounts = AccountManager.instance.getAllAccounts();
							for (Account a : accounts) {
								System.out.println(String.format("%d- %s", a.getId(), a.getName()));
							}
							int aid = scanner.nextInt();

							ArrayList<Outcome> outcomes;
							try {
								outcomes = OutcomeManager.instance.getCurrentMonthOutcomes(cid, aid);
								for (Outcome outcome : outcomes) {
									System.out.println(String.format(
											"Outcome: Amount: %.3f $\t  Description:%s\t Date:%s\t  C_id:%d\t  a_id:%d",
											outcome.getAmount(), outcome.getDescription(), outcome.getFormatedDate(),
											outcome.getC_id(), outcome.getA_id()));
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}

						} else {
							System.out.println("Wrong input");
						}

					} else {
						System.out.println(
								"statistics are locked do you want to upgrade account to permium? \"cost 3$\"");
						System.out.println("Enter (1) for yes (0) for no?");
						int choice1 = scanner.nextInt();
						if (choice1 == 1) {
							System.out.println("Enter(1) to upgrade account ");
							int choice2 = scanner.nextInt();
							if (choice2 == 1) {
								System.out.println("Enter Card number");
								int number = scanner.nextInt();

								System.out.println("Enter Card Expired date");
								String date = scanner.next();

								System.out.println("Enter cvc");
								int cvc = scanner.nextInt();
								try {
									UserManager.instance.upgradeUser();
									System.out.println("Thank you! account has been upgraded succefully");
								} catch (SQLException e) {
									e.printStackTrace();
								}

							} else {
								System.out.println("Wrong number entered");
							}

						} else if (choice1 == 0) {
							showMenu();
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

			case 0: {
				System.out.println("you logged out successfully!..");
			}

			}

		} while (choice != 0);
	}

	public static void main(String[] args) {

		int choice = 0;

		do {

			System.out.println("--------------------------------");
			System.out.println("Welcome to \"Spendiser\" application");
			System.out.println("Enter (1) to Register");
			System.out.println("Enter (2) to Login");
			System.out.println("Enter (0) to Exit");
			System.out.println("--------------------------------");

			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter Username:");
				String username = scanner.next();

				System.out.println("Enter Password:");
				String password = scanner.next();

				System.out.println("Confirm Password:");
				String cpassword = scanner.next();

				if (!password.equals(cpassword)) {
					System.out.println("Passwords are not matched");
					continue;
				}
				System.out.println("Enter nickname");
				String nickname = scanner.next();

				System.out.println("Select Gender (1) for 'Male' (0) for 'Female' ");
				int Gender = scanner.nextInt();

				System.out.println("Enter birthdate");
				String birthdate = scanner.next();

				try {
					User u = new User(username, password, nickname, Gender, birthdate);
					UserManager.instance.signUp(u);
					System.out.println("Congrats!.. your account has been created please login");
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				System.out.println("Enter Username:");
				String username = scanner.next();

				System.out.println("Enter Password:");
				String password = scanner.next();

				User user;
				try {
					user = UserManager.instance.signIn(username, password);
					if (user != null) {
						System.out.println(String.format("congrats..! %s You signed in successfully ", user.getName()));
						showMenu();
					} else {
						System.out.println("Wrong username or password.");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}

			default:
				choice = 0;
				break;
			}

		} while (choice != 0);

	}
}
