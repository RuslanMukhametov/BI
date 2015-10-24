package Test1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Руслан on 12.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размеры печатной платы");
        System.out.println("Ширина: ");
        int pcbWidth = 200;
        /*int pcbWidth = scanner.nextInt();*/
        System.out.println("Высота: ");
        int pcbHeight = 200;
        /*int pcbHeight = scanner.nextInt();*/

        System.out.println("Введите минимальную дистанцию между элементами");
        int minDist = 5;
        //int minDist = scanner.nextInt();
        /*System.out.println("Введите громкость в диапазоне от 0 до 1");
        double volume = scanner.nextInt();*/
        // Добавить проверку на правильность ввода

        System.out.println("Введите количество поколений (Итераций)");
        /*int genNumb = scanner.nextInt();*/
        int genNumb = 10;
        /*System.out.println("Введите частоту пульсации в диапазоне от 0 до 1");
        double pulseFreq = scanner.nextInt();*/
        // Добавить проверку на правильность ввода

        System.out.println("Введите минимальную частоту");
        /*int minFreq = scanner.nextInt();*/
        int minFreq = 1;
        System.out.println("Введите максимальную частоту");
        /*int maxFreq = scanner.nextInt();*/
        int maxFreq = 4;
        System.out.println("Введите максимальный размер шага при поиске");
        /*int maxStep = scanner.nextInt();*/
        int maxStep = 5;

        System.out.println("Введите размеры и координаты центра запретной зоны");
        System.out.println("Ширина: ");
        /*int widthRA = scanner.nextInt();*/
        int widthRA = 30;
        System.out.println("Высота: ");
        /*int heightRA = scanner.nextInt();*/
        int heightRA = 30;
        System.out.println("X: ");
        /*int xRA = scanner.nextInt();*/
        int xRA = 150;
        System.out.println("Y: ");
        /*int yRA = scanner.nextInt();*/
        int yRA = 150;

        int[][] matrix;
        System.out.println("Введите количество элементов:");
        int numb = 3;
        /*int numb = scanner.nextInt();*/
        matrix = new int[numb][numb];
        System.out.println("Заполните матрицу смежности.");
        for (int i = 0; i < numb; i++) {
            for (int j = i + 1; j < numb; j++){
                System.out.println("Введите количество соединений " + " " + i + " и " + j + " элементов:");
                int first = scanner.nextInt();
                matrix[i][j] = first;
            }
        }
        for (int i = 0; i < numb; i++) {
            for (int x = 0; x < numb; x++) {
                matrix[x][i] = matrix[i][x];
            }
        }
        for (int i = 0; i < numb; i++) {
            for (int x = 0; x < numb; x++) {
                System.out.print(matrix[i][x] + "\t");
            }
            System.out.println();
        }
        ArrayList<Element> elements = new ArrayList<Element>();
        ArrayList<Element> initialPlacement = new ArrayList<Element>();
        for (int i = 0; i < numb; i++){
            System.out.println("Введите ширину элемента " + i);
            int width = scanner.nextInt();
            System.out.println("Введите высоту элемента " + i);
            int height = scanner.nextInt();

            //Начальное размещение элементов в пределах печатной платы
            //НЕ РАБОТАЕТ! ИСПРАВИТЬ!!!
            /*double centreX = (elements.get(i).getWdth())/2 + Math.random() * ((pcbWidth - elements.get(i).getWdth()/2 ) + 1);
            double centreY = (elements.get(i).getHeght())/2 +  Math.random() * ((pcbHeight - elements.get(i).getHeght()/2 ) + 1);
            int centreX = (int)centreX;
            int centreY = (int)centreY;*/
            double centrX = Math.random() * 50;
            double centrY = Math.random() * 50;
            int centreX = (int) centrX;
            int centreY = (int) centrY;

            Element element = new Element(centreX, centreY, width, height);
            Element element1 = new Element(centreX, centreY, width, height);
            elements.add(element);
            initialPlacement.add(element1);
        }

        for (int i = 0; i < elements.size(); i++){
            System.out.print("Координаты центра элемента " + i + " по Х:");
            System.out.println(elements.get(i).getCentreX() + " ");
            System.out.print("Координаты центра элемента " + i + " по Y:");
            System.out.println(elements.get(i).getCentreY() + " ");
        }
        System.out.println("Количество элементов = " + elements.size());

        //Проводим выполнение алгоритма, выполняем перемещение
        // и сохраняем новые значения центров элементов
        System.out.println("Начинаем выполнять алгоритм " + genNumb +" количество раз");
        for (int j = 0; j < genNumb; j++) {
            for (int i = 0; i < elements.size(); i++) {
                int xBest = 0;
                for (int x = 0; x < matrix.length; x++){
                    if (matrix[i][x] > xBest){
                        xBest = x;
                    }
                }
                elements.get(i).setCentreX(Algorithm.movingX(elements.get(i).getCentreX(), minFreq, maxFreq, elements.get(xBest).centreX, maxStep));
                elements.get(i).setCentreY(Algorithm.movingY(elements.get(i).getCentreY(), minFreq, maxFreq, elements.get(xBest).centreY, maxStep));
                Algorithm.checkConfines(elements);
            }
            // Добавить проверку нарушения ограничений
            System.out.println("После выполнения " + j + " итерации:" );
            for (int i = 0; i < elements.size(); i++){
                System.out.print("Координаты центра элемента " + i + " по Х:");
                System.out.println(elements.get(i).getCentreX() + " ");
                System.out.print("Координаты центра элемента " + i + " по У:");
                System.out.println(elements.get(i).getCentreY() + " ");
            }
        }

        System.out.println("После выполнения алгоритма");
        for (int i = 0; i < elements.size(); i++){
            System.out.print("Координаты центра элемента " + i + " по Х:");
            System.out.println(elements.get(i).getCentreX() + " ");
            System.out.print("Координаты центра элемента " + i + " по У:");
            System.out.println(elements.get(i).getCentreY() + " ");
        }
        System.out.println("Значение целевой функции = " + Algorithm.targetFunction(matrix, elements));
        JFrame window = new MainWindow(pcbWidth, pcbHeight);
        window.setVisible(true);
        Paint paint = new Paint(initialPlacement, elements, pcbWidth, pcbHeight, widthRA, heightRA, xRA, yRA);
        window.add(paint);


    }
}
