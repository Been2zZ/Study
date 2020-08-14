package ssafy0814.Weather;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class WeatherGuiMain {

	JFrame f;
	JButton b;
	JList li;
	JTextArea ta;
	WeatherDAO dao;

	public WeatherGuiMain() {
		dao = WeatherDAO.getInstance();
		createGUI();
		addEvent();
		showList();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showList();

			}
		});
		li.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Weather wh = (Weather) li.getSelectedValue();
				ta.setText(wh.toString());

			}
		});
	}

	private void showList() {

		li.removeAll();
		li.setListData(dao.getWeatherList().toArray());
	}

	private void createGUI() {
		f = new JFrame("Weather");
		JPanel p = new JPanel();
		b = new JButton("Weather List 호출");
		li = new JList<>();
		ta = new JTextArea("      ");
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b, BorderLayout.NORTH);
		p.add(li);
		f.setLayout(new GridLayout(2, 1, 5, 5));
		f.add(p);
		f.add(ta);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		WeatherGuiMain main = new WeatherGuiMain();

	}
}