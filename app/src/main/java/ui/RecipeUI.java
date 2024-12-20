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
                    System.out.println();
                        System.out.println("Recipes:");
                        // 設問1: 一覧表示機能
                        // 困難 readRecipes()で帰ってきたArrayListを、このクラス上で変数にして保持したいがやり方が不明
                        // 困難 readRecipes()の最後にnullがreturnしている。どういう動作なのか？
                        // 困難 無限ループする
                        
                        // とりあえずインスタンス作っておく
                        RecipeFileHandler ui2 = new RecipeFileHandler();
                        // Arraylist rowDateを呼び出す（recipes.txtを1行ごとに配列化したものを受け取る）
                        // 受け取ったrowDateの1つの要素（recipes.txtの1行）を、新しい1つの配列に収納する -> ここは省略できるはず
                        // １行を分割した新しい配列の、インデックス０番目を料理名、それ以降を材料としてループで出力する
                        // １行を出力するごとに、"-----------------------------------"を出力し、次の配列へ進む
                        ArrayList<String> sets = new ArrayList<>();
                        for (int i = 0; i < ui2.readRecipes().size() - 1; i++) { // rowDateの要素数だけ、下記の処理を実行する
                            sets.add(ui2.readRecipes().get(i)); // i行目をsetsの要素に収納する
                            String[] a = sets.get(i).split(","); // setsの1つの要素を,で分解し、分解したものを配列aに収納する

                            System.out.println("-----------------------------------");
                            System.out.println("Recipe Name: " + a[0]); // a[0]は料理名
                            System.out.print("Main Ingredients: ");
                            for (int j = 1; j < a.length - 1; j++) {
                                System.out.print(a[j]); // a[j]は材料名
                                for (int k = 0; k < a.length -2; k++) {
                                    System.out.print(", ");
                                }
                            }
                        System.out.println();
                        }
                        System.out.println("-----------------------------------");
                        break;

                            // こちらは初期に書いたコードなので、気にしないでください
                            // エラー理由 ui2.readRecipes().get(i).split(",")がStringまで分解されているのに、配列[]にStringを定義して、ややこしくしているため、type mismatchが発生する
                            // for (String[] set : ui2.readRecipes().get(i).split(","))  { // ここで、rowDateの1つの要素を、","で分けて新しい配列に収納する
                                // System.out.println("-----------------------------------");
                                // System.out.println("Recipe Name: " + a[0]); // set[0]は、行の一番最初
                                // System.out.print("Main Ingredients: ");
                                // for (int j = 1; j < a.length - 1; j++) {
                                //     System.out.print(a[j]);
                                //     for (int k = 0; k < a.length -2; k++) {
                                //         System.out.print(", ");
                            //         }
                            //     }
                            // }

                    case "2":
                        // 設問2: 新規登録機能
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

    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {

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

