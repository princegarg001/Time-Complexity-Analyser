package adaa;
import java.io.*;
import java.util.regex.*;

public class timecomplexity_analyser {

    public static int countLoopNesting(String code) {
        int maxDepth = 0, currentDepth = 0;
        Pattern loopPattern = Pattern.compile("\\b(for|while)\\b");

        try (BufferedReader reader = new BufferedReader(new StringReader(code))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = loopPattern.matcher(line);
                if (matcher.find() && line.contains("{")) { 
                    currentDepth++;
                    maxDepth = Math.max(maxDepth, currentDepth);
                }
                if (line.trim().equals("}")) { 
                    currentDepth = Math.max(0, currentDepth - 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxDepth;
    }

    public static String estimateComplexity(int depth) {
        String[] complexities = {"O(1)", "O(n)", "O(n^2)", "O(n^3)", "O(2^n)"};
        return complexities[Math.min(depth, complexities.length - 1)];
    }

    public static void main(String[] args) {
        
        String filename = "C:\\Users\\princ\\eclipse-workspace\\javaprogram\\src\\adaa\\src\\adaa\\analysing.java";

        StringBuilder code = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                code.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        int maxDepth = countLoopNesting(code.toString());
        String complexity = estimateComplexity(maxDepth);

        System.out.println("Estimated Time Complexity: " + complexity);
    }
}
