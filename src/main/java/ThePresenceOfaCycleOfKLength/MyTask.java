package main.java.ThePresenceOfaCycleOfKLength;
import com.mathsystem.api.graph.oldmodel.AbstractGraph;
import com.mathsystem.api.graph.oldmodel.Vertex;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import java.util.Scanner;

/*
    Псевдокод для ориентированного графа (первый вариант)

    Инициализация:
    CycleLength - длина цикла
    Start - первая вершина для обхода
    Used - список вершин, проверенных на отсутствие циклов длины CycleLength

    Структура вершин для агоритма Vertexes:
        Ver - вершина (стандартный класс Зайкова)
        Hit - сколько раз вошли в вершину
        Source - откуда попали, если попали один раз

    Цикл по списку вершин графа (Start - текущая вершина):
        Queue - очередь вершин структуры Vertexes
        Цикл по исходящим ребрам Start(E - ребро на рассмотрении):
            W = E.ребро(Start)
            Queue <- Vertexes(Ver = W, Hit = 1, Source = Start)
        Цикл длины CycleLength - 1:
            QueueLength - длина очереди на момент начала итерации
            Цикл длины QueueLength:
                Queue -> U - вершина
                Цикл по ребрам U:
                    W = ребро(U)
                    Если W не входит в Used и не равно Start:
                        Если U.Hit != 1:
                            Если элемента, у которого Ver == W нет в Queue:
                                Queue <- Vertexes(Ver = W, Hit = 1, Source = U)
                            Иначе:
                                Изменяем параметры элемента в Queue на Vertexes(Ver = W, Hit = Hit+1, Sources = NULL)
                        Иначе:
                            Если W != U.Source:
                                Если элемента, у которого Ver == W нет в Queue:
                                    Queue <- Vertexes(Ver = W, Hit = 1, Source = U)
                                Иначе:
                                    Изменяем параметры элемента в Queue на Vertexes(Ver = W, Hit = Hit+1, Sources = NULL)
        Пока Queue не пуст:
            Queue -> U
            Цикл по ребрам U:
                Если ребро(U.Ver) == Start:
                    Заканчиваем работу программы и выводим "Успех"
            Used <- Start
    Заканчваем работу и выводим "Провал"



    Queue {
        [Ver = V, Hit = 2, Source = null],
        [Ver = W, Hit = 2, Source = null],
        [Ver = Q, Git = 2, Source = null]
    }
 */

public class MyTask extends AbstractGraph {

    private static class Vertexes {
        private Vertex ver, source;
        private int hit;

        private Vertexes(Vertex ver, int hit, Vertex source) {
            this.ver = ver;
            this.hit = hit;
            this.source = source;
        }
    }

    public static int Find(Vertex V, List<Vertexes> List){
        for(int i=0; i < List.size(); i++){
            if(List.get(i).ver == V){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int CycleLength;
        Vertex Start;
        Vertex W;
        Vertexes U;
        File file = new File("graph.txt");
        List<Vertex> Used = new ArrayList();
        List<Vertexes> QueueV = new ArrayList();
        DirectedGraph Graph = null;


        Scanner console = new Scanner(System.in);
        CycleLength = console.nextInt();

        for (int CurrentV = 0; CurrentV < Graph.getVertices().size(); CurrentV++) {
            for (int CurrentE = 0; CurrentE < Graph.getVertices().get(CurrentV).getEdgeList().size(); CurrentE++) {
                W = Graph.getVertices().get(CurrentV).getEdgeList().get(CurrentE).other(Graph.getVertices().get(CurrentV));

                Vertexes NewVer = new Vertexes(W, 1, Graph.getVertices().get(CurrentV));
                QueueV.add(NewVer);
            }
            for (int i = 0; i < CycleLength - 1; i++) {
                int QueueLength = QueueV.size();
                for (int j = 0; j < QueueLength; j++) {
                    U = QueueV.get(0);
                    QueueV.remove(0);
                    if (U != null) {
                        for (int CurrentE = 0; CurrentE < U.ver.getEdgeList().size(); CurrentE++) {
                            W = U.ver.getEdgeList().get(CurrentE).other(Graph.getVertices().get(CurrentV));
                            if (Used.contains(W) == false & W != Graph.getVertices().get(CurrentV)) {
                                if (U.hit != 1) {
                                    if(QueueV.contains(W) == false) {
                                        Vertexes NewVer = new Vertexes(W, 1, U.ver);
                                        QueueV.add(NewVer);
                                    }
                                    else{
                                        int findedInd = Find(W, QueueV);
                                        Vertexes NewVer = new Vertexes(W,QueueV.get(findedInd).hit+1, null);
                                        QueueV.set(Find(W, QueueV), NewVer);
                                    }
                                }
                                else{
                                    if(W != U.source){
                                        if(QueueV.contains(W) == false) {
                                            Vertexes NewVer = new Vertexes(W, 1, U.ver);
                                            QueueV.add(NewVer);
                                        }
                                        else{
                                            int findedInd = Find(W, QueueV);
                                            Vertexes NewVer = new Vertexes(W,QueueV.get(findedInd).hit+1, null);
                                            QueueV.set(Find(W, QueueV), NewVer);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            while(!QueueV.isEmpty()){
                U = QueueV.get(0);
                QueueV.remove(0);
                for (int CurrentE = 0; CurrentE < U.ver.getEdgeList().size(); CurrentE++) {
                    if(U.ver.getEdgeList().get(CurrentE).other(Graph.getVertices().get(CurrentV)) == Graph.getVertices().get(CurrentV)){
                        System.out.println("YES!");
                        System.exit(0);
                    }
                    Used.add(Graph.getVertices().get(CurrentV));
                }

            }
        }
        System.out.println("NO!");
        System.exit(0);
    }
}
