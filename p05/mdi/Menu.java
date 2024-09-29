package mdi;

import java.util.ArrayList;

public class Menu{
    private ArrayList <MenuItem> items = new ArrayList<>();
    
    public void addMenuItem(MenuItem item){
        items.add(item);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<items.size(); ++i){
            sb.append(" "+ i + "] "+ items.get(i) + "\n");
        }
        return sb.toString();
    }

    public void run(int i){
        items.get(i).run();
    }
    public int size() {
        return items.size(); 
    }
}