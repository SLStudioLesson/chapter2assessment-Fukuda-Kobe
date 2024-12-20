package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                        case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        // ArrayListを用意
        ArrayList<String> row = new ArrayList<>();
        row = fileHandler.readRecipes();

        if (row.isEmpty()) { // 空のArrayListのとき、trueを返すメソッド
            System.out.println("No recipes available.");
        } else {
            System.out.println();
            System.out.println("Recipes:");
            for (int i = 0; i <= row.size() - 1; i++) { // rowの要素数だけ、下記の処理を実行する
                String[] items = row.get(i).split(","); // rowの1つの要素（recipe.txtのi行目）をカンマ(,)で分解し、分解したものを配列itemsに収納する
    
                // i行目のレシピ
                System.out.println("-----------------------------------");
                // 料理名の出力
                System.out.println("Recipe Name: " + items[0]); // items[0]は料理名
                // 材料の出力
                System.out.print("Main Ingredients: ");
                for (int j = 1; j <= items.length - 1; j++) { // itemsのindex[1]以降の材料を出力する
                    System.out.print(items[j]); // a[j]は材料名
                        if (j < items.length - 1) { // 材料名ごとに、カンマと空白を入れる
                            System.out.print(",");
                        }
                    }
                System.out.println();
                }
            System.out.println();
        }
        }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        // 料理名の受け取り
        System.out.print("Enter recipe name: ");
        String recipeName = reader.readLine();
        // 材料の受け取り
        System.out.print("Enter main ingredients (comma separated): ");
        String ingredients = reader.readLine();
        // addRecipeの呼び出し（引数を渡す）
        fileHandler.addRecipe(recipeName, ingredients);

        
    }


    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }
}

