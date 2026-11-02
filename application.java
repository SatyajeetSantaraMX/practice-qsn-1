import java.util.*;
class UnsupportedOSException extends Exception
{
     public UnsupportedOSException(String message) 
     {
        super(message);
     }
}
class InsufficientStorageException extends Exception
{
    public InsufficientStorageException(String message)
    {
        super(message);
    }
}
class NetworkUnavailableException extends Exception
{
    public NetworkUnavailableException(String message)
    {
        super(message);
    }
     public NetworkUnavailableException(String message, Throwable cause)
    {
        super(message,cause);
    }
    
}
class ServerTimeoutException extends Exception {
    public ServerTimeoutException(String message) {
        super(message);
    }

    public ServerTimeoutException(String message,Throwable cause) {
        super(message,cause);
    }
}


class DeviceManager{
    private Scanner scanner;
    public DeviceManager (Scanner scanner) {
        this.scanner = scanner;
    }

    public void checkDeviceCompatibility()
    
        throws UnsupportedOSException,InsufficientStorageException{
            System.out.println("enter OS version");
            int osVersion =scanner.nextInt();

            System.out.print("enter minimum support version");
            int minimumOsVersion=scanner.nextInt();

            System.out.println("enter available storage");
            int storage=scanner.nextInt();

            System.out.println("\nChecking device compatibility...");

            if (osVersion<minimumOsVersion)
            {
                throw new UnsupportedOSException("ur os is not supported");

            }
            if (storage <500)
            {
                throw new InsufficientStorageException("insufficient storage");
            }
                    System.out.println("Device compatibility veriified");

        }
    }

    class NetworkService
    {
        private Scanner scanner;
        public NetworkService(Scanner scanner)
        {
            this.scanner=scanner;
        }
        public void connectToServer()
        throws NetworkUnavailableException ,ServerTimeoutException{
            System.out.println("select network condition");
            System.out.println("1- Internet available");
            System.out.println("2- not available");
            int networkChoice =scanner.nextInt();

            if(networkChoice==2)
            {
                throw new NetworkUnavailableException("internet not availabelel");
            }

if (networkChoice!=1)
    {
        throw new NetworkUnavailableException("invalid network connection selected");
              
        }
        System.out.println("\nSelect Server Response:");
        System.out.println("1. Server Responds Successfully");
        System.out.println("2.Server Times Out");
        System.out.println("3.Server Times Out Twice, Then Succeeds");
         System.out.print("Enter your choice: ");
        int serverChoice = scanner.nextInt();

        System.out.println("\nConnecting to server...");

        // conn sucssfll
        if (serverChoice == 1) {
            System.out.println("Server connected successfully.");
            return;
        }
         if (serverChoice == 2) {

            ServerTimeoutException lastException = null;

            for (int attempt = 1; attempt <= 3; attempt++) {

                try {
                    throw new ServerTimeoutException(
                            "Server timeout."
                    );

                } catch (ServerTimeoutException e) {

                    lastException = e;

                    System.out.println("Attempt " + attempt+" failed: Server timeout"
                    );
                }
            }
            throw new ServerTimeoutException(
                    "Unable to connect to the server.",
                    lastException
            );
         }
        if (serverChoice == 3) 
            {
            for (int attempt = 1; attempt <= 3; attempt++) 
                {
                try {
                    if (attempt < 3) {
                        throw new ServerTimeoutException("Server timeout.");
                    }
                    System.out.println("Attempt 3: Server connected successfully." );
                } 
                catch (ServerTimeoutException e) 
                {

                    System.out.println( "Attempt " + attempt +" failed: Server timeout.");

                    continue;
                }

                return;
            }
        }

        throw new ServerTimeoutException(
                "Invalid server response selected."
        );
    }
}
class ExceptionHandler {
    public static void handleException(Exception e) {
        if (e instanceof UnsupportedOSException) {
            System.out.println(
                    "Error: Your operating system version is not supported."
            );

        } 
        else if (e instanceof InsufficientStorageException) 
            {
            System.out.println(
                    "Error: Insufficient device storage."
            );
        } else if (e instanceof NetworkUnavailableException) 
            {

            System.out.println(
                    "Error: Internet connection is unavailable."
            );
            System.out.println(
                    "Please check your network and try again."
            );
        } else if (e instanceof ServerTimeoutException) 
            {
            System.out.println( "Error: Unable to connect to the server.");
            System.out.println("Please try again later.");
        } else
             {
            System.out.println(
                    "Error: An unexpected error occurred."
            );
        }
        System.out.println("\nTechnical details:");
        System.out.println(
                e.getClass().getSimpleName() +": " +e.getMessage()
        );
        if (e.getCause() != null) 
            {
            System.out.println(
                    "Original cause: " +
                    e.getCause().getClass().getSimpleName()
            );
            System.out.println(
                    "Cause message: " +
                    e.getCause().getMessage()
            );
        }
    }
}
class MobileApplication {
    private DeviceManager deviceManager;
    private NetworkService networkService;
    public MobileApplication(Scanner scanner) {
        deviceManager = new DeviceManager(scanner);
        networkService = new NetworkService(scanner);
    }
    public void launchApp() {
 try {
            try {
                deviceManager.checkDeviceCompatibility();
            } 
            catch (UnsupportedOSException |
                     InsufficientStorageException e) 
                     {
                ExceptionHandler.handleException(e);
                return;
            }
            try {

                networkService.connectToServer();

                System.out.println(
                        "\nApplication launched successfully."
                );
            } catch (NetworkUnavailableException |
                     ServerTimeoutException e) 
                     {
                throw e;
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        } finally {
            System.out.println(
                    "\nApplication startup process completed."
            );
        }
    }
}



public class application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MobileApplication application =
                new MobileApplication(scanner);

        while (true) {

            System.out.println(
                    "\n===== SmartLife Mobile Application ====="
            );
            System.out.println("1. Launch Application");
            System.out.println("2. Exit");
            System.out.print("\nEnter your choice: ");

            int choice;

            try {

                choice = scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.nextLine();
                continue;
            }


            switch (choice) {

                case 1:
                    application.launchApp();
                    break;

                case 2:
                    System.out.println(
                            "Exiting SmartLife..."
                    );

                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Invalid menu choice. Please select 1 or 2."
                    );
            }
        }
    }

    }


