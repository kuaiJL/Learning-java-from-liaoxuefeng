package s_DesignPatterns.structural.Composite;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		Node root = new ElementNode("body");
		root.add(new ElementNode("h").add(new TextNode("Tom")).add(new TextNode("Alice")));
		root.add(new ElementNode("a").add(new TextNode("Bob")).add(new TextNode("Grace"))
				.add(new CommentNode("comment...")));
		System.out.println(root.toXml());
	}
}
