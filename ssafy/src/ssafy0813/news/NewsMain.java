package ssafy0813.news;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	private JFrame f;
	private JButton b;
	private JList li;
	private JTextArea ta;
	private INewsDAO dao_dom;
	private INewsDAO dao_sax;
	
	
	public NewsMain() {
		dao_dom = NewsDAODOMImpl.getInstance();
		dao_sax = NewsDAOSAXImpl.getInstance();
		createGUI();
		addEvent();
		showList();
	}

	public void createGUI() {
		f = new JFrame("NewsList");
		JPanel p = new JPanel();
		b = new JButton("News List 호출");
		li = new JList();
		ta = new JTextArea("");
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b, "North");
		p.add(li);
		f.setLayout(new GridLayout(2, 1, 5, 5));
		f.add(p);
		f.add(ta);
		f.setSize(400, 500);
		f.setVisible(true);
	}
	
	public void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		li.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				News n = (News)li.getSelectedValue();
				ta.setText(n.getDesc());
			}
		});
	}
	
	public void showList() {
		List<News> list = dao_dom.getNewsList("http://rss.etnews.com/Section902.xml");
//		List<News> list = dao_sax.getNewsList("http://rss.etnews.com/Section902.xml");
		li.removeAll();
		li.setListData(list.toArray());
	}

	public static void main(String[] args) {
		new NewsMain();
	}

}
