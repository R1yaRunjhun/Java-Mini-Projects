import java.util.Scanner;



class VideoLauncher {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean check=true;
        VideoStore store = new VideoStore(10); // jitna video store krna h let 10. 
        do{
            System.out.println("MAIN");
            System.out.println("--------");
            System.out.println("1.Add Videos");
            System.out.println("2.Check Out Video");
            System.out.println("3.Return Video");
            System.out.println("4.Receive Rating");
            System.out.println("5.List Inventory");
            System.out.println("6.Exit");
            System.out.print("Enter your option(1....6): ");
            int choice = Integer.parseInt(in.nextLine());

			switch (choice)
			{
				case 1:
					System.out.print("Enter the name of the video you want to add:  ");
					String title = in.nextLine();
					store.addVideo(title);
					System.out.println("Video "+'"'+title+'"'+" added successfully.");
					break;
				case 2:
					System.out.print("Enter the name of the video you want to check out: ");
					title = in.nextLine();
					store.checkOut(title);
					System.out.println("Video "+'"'+title+'"'+" checked out successfully.");
					break;
				case 3:
					System.out.print("Enter the name of the video you want to return : ");
					title = in.nextLine();
					store.returnVideo(title);
					System.out.println("Video "+title+" return  successfully.");
					break;
				case 4:
					System.out.print("Enter the name of the video you want to rate:");
					title = in.nextLine();
					System.out.print("Enter the rating for this: ");
					double rating = Double.parseDouble(in.nextLine());
					store.receiveRating(title, rating);
					break;
				
				case 5:
					store.listInventory();
					break;
				case 6:
					System.out.println("Exiting...!! Thanks for using the application.");
						check=false;
					break;
			}
		}while(check);
		in.close();
    }
}

class Video {
    private String title;
    private boolean checked;
    private boolean returned;
    int count;
    private double rating;

    Video(String name) {
        checked = false;
        returned = true;
        rating = 0;
        title = name;
    }

    void setChecked(boolean status) {
        checked = status;
    }

    void setReturned(boolean status) {
        returned = status;
    }

    boolean isChecked() {
        return checked;
    }

    boolean isReturned() {
        return returned;
    }

    void rateVideo(double user_rating) {
		
		rating=user_rating;
        
    }

    String getTitle() {
        return title;
    }

    double getRating() {
        return rating;
    }
}

class VideoStore {
    private Video[] videos;
    private int c;
    boolean isOpen;

    VideoStore(int n) {
        videos = new Video[n];
        c = 0;
        isOpen = true;
    }

   
    void addVideo(String title) {
        videos[c] = new Video(title);
        c++;
    }

    boolean checkOut(String title) {
        for (int i = 0; i < c; i++) {
            if (videos[i].getTitle().equals(title)) {
                if (!videos[i].isChecked()) {
                    videos[i].setChecked(true);
                    videos[i].setReturned(false);
                    return true;
                }
            }
        }
        return false;
    }

    void returnVideo(String title) {
        for (int i = 0; i < c; i++) {
            if (videos[i].getTitle().equals(title)) {
                videos[i].setChecked(false);
                videos[i].setReturned(true);
                break;
            }
        }
    }

    void receiveRating(String title, double usr_rating) {
        for (int i = 0; i < c; i++) {
            if (videos[i].getTitle().equals(title)) {
                videos[i].rateVideo(usr_rating);
                break;
            }
        }
    }

    void listInventory() {
        
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", "Name", "Checkout Status", "Rating");
        for(int i=0;i<c;i++)
        {
            System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", videos[i].getTitle(), videos[i].isChecked(), videos[i].getRating());
        }
        
        System.out.println("-----------------------------------------------------------------------------------------------");

    }
}