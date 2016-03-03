
import org.lightcouch.*;

public class Application
{
    public static void main(String[]args)
    {

        //CouchDbClient dbClient = new CouchDbClient("couchdb.properties");

        //CouchDbClient dbClient = new CouchDbClient("db-name", true, "http", "127.0.0.1", 5984, "", "");

        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("projectpath")
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("127.0.0.1")
                .setPort(5984)
                .setUsername("")
                .setPassword("")
                .setMaxConnections(100)
                .setConnectionTimeout(0);

        CouchDbClient dbClient = new CouchDbClient(properties);


        Foo foo = new Foo();

        Response response = dbClient.save(foo);
        // dbClient.save(foo);   // save, ignore response
        // dbClient.batch(foo);  // saves batch

        dbClient.update(foo);
        //dbClient.shutdown();
    }
}
class Foo
{
    int age;
    String name;
    Foo()
    {
        age=10;
        name="Dummy";
    }
}

/*
public class Application {

    public static void main(String[] args) {
        CouchDbClient dbClient = new CouchDbClient("couchdb.properties");
        DesignDocument designDoc;
        designDoc = dbClient.design().getFromDesk("example");
        Response response= dbClient.design().synchronizeWithDb(designDoc);

        Scanner sc = new Scanner(System.in);
        System.out.print("First name: ");
        String firstName = sc.nextLine();
        System.out.print("Middle name: ");
        String middleName = sc.nextLine();
        System.out.print("Last name: ");
        String lastName = sc.nextLine();

        int dupCount;
        String[] keys = {firstName, lastName};
        dupCount = dbClient.view("example/by_name").key((Object[]) keys)
                .query(Name.class).size();

        if (dupCount > 0) {
            System.out.println("Found a copy");
        }
        else {
            Name name = new Name();
            name.first = firstName;
            name.last = lastName;
            name.middle = middleName;
            dbClient.save(name);
            System.out.println("New name was submitted");
        }

        List<Name> names = dbClient.view("example/by_all").includeDocs(true).query(Name.class);
        System.out.println("\n Names list:");
        for (Name myName : names) {
            System.out.println(myName.first + " " +
                    myName.middle + " " +
                    myName.last);
        }
        dbClient.shutdown();
    }


}
class Name extends Document {
    public String first;
    public String middle;
    public String last;
}*/
/*
public class Application {
    JFrame f;
    JTextField t1,t2,t3;
    JLabel l1,l2,l3,msglabel;
    JPanel p;
    JButton b;
    public Application()
    {
        f=new JFrame("Connect to Couch");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(270,450);
        f.setLayout(null);

        p=new JPanel();
        p.setSize(250,400);
        p.setBackground(new Color(200,200,100));

        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);

        l1=new JLabel("Name");
        l1.setSize(30,20);
        l2=new JLabel("Age");
        l2.setSize(30,20);
        l3=new JLabel("Class");
        l3.setSize(30,20);
        msglabel=new JLabel("");
        msglabel.setSize(30,20);

        b=new JButton("Save to DB");
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                saveToDB();
            }

        });

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(b);
        p.add(msglabel);

        f.add(p);
    }

    private void saveToDB()
    {
        msglabel.setText("Saved to Database");
    }
    public static void main(String[]args)
    {
        new Application();
    }
}
*/