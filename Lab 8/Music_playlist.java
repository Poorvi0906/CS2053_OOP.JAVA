import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylist {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> playlist = new LinkedList<>();
        int choice;

        do {
            System.out.println("\n=== Music Playlist Menu ===");
            System.out.println("1. Add Song at Beginning");
            System.out.println("2. Add Song at End");
            System.out.println("3. Remove First Song");
            System.out.println("4. Remove Last Song");
            System.out.println("5. Replace Song at Index");
            System.out.println("6. Display Playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    playlist.addFirst(input.nextLine());
                    System.out.println("Song added at the beginning!");
                    break;

                case 2:
                    System.out.print("Enter song name: ");
                    playlist.addLast(input.nextLine());
                    System.out.println("Song added at the end!");
                    break;

                case 3:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeFirst());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    break;

                case 4:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeLast());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    break;

                case 5:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty!");
                        break;
                    }
                    System.out.print("Enter index to replace (0 to " + (playlist.size() - 1) + "): ");
                    int index = input.nextInt();
                    input.nextLine();
                    if (index >= 0 && index < playlist.size()) {
                        System.out.print("Enter new song name: ");
                        String newSong = input.nextLine();
                        playlist.set(index, newSong);
                        System.out.println("Song replaced successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 6:
                    displayPlaylist(playlist);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            // Show playlist after every action except Exit
            if (choice != 0 && choice != 6) {
                displayPlaylist(playlist);
            }

        } while (choice != 0);

        input.close();
    }

    // Method to display all songs in playlist
    public static void displayPlaylist(LinkedList<String> playlist) {
        System.out.println("\n--- Current Playlist ---");
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println(i + ": " + playlist.get(i));
            }
        }
    }
}
