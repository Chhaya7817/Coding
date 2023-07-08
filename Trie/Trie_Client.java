public class Trie_Client {
    public static void main(String[] args) {

        Trie t=new Trie();
        t.insert("raj");
        t.insert("raja");
        t.insert("apple");
        t.insert("apala");
        System.out.println(t.search("raj"));
        System.out.println(t.search("ra"));

    }
}
