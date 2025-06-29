import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ChatBotGUI extends JFrame implements ActionListener {
    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    Map<String, String> responses;

    ChatBotGUI() {
        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBounds(20, 20, 440, 350);
        add(scrollPane);

        inputField = new JTextField();
        inputField.setBounds(20, 390, 330, 30);
        add(inputField);

        sendButton = new JButton("Send");
        sendButton.setBounds(360, 390, 100, 30);
        sendButton.addActionListener(this);
        add(sendButton);

        setVisible(true);

        initResponses();
        botResponse("Hello! I'm your AI Assistant. Ask me anything!");
    }

    void initResponses() {
        responses = new HashMap<>();
        responses.put("hello", "Hi there!");
        responses.put("hi", "Hello!");
        responses.put("how are you", "I'm just code, but I'm running fine 😄.");
        responses.put("your name", "I'm ChatBot v1.0.");
        responses.put("what is java", "Java is a high-level, object-oriented programming language.");
        responses.put("who made you", "I was created by a Java developer.");
        responses.put("bye", "Goodbye! Have a great day.");
        responses.put("exit", "Exiting now. Bye!");
    }

    String getResponse(String input) {
        input = input.toLowerCase();
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }
        return "Sorry, I don't understand that.";
    }

    void botResponse(String text) {
        chatArea.append("Bot: " + text + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = inputField.getText().trim();
        if (userInput.isEmpty()) return;

        chatArea.append("You: " + userInput + "\n");
        String response = getResponse(userInput);
        botResponse(response);
        inputField.setText("");

        if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("bye")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ChatBotGUI();
    }
}
