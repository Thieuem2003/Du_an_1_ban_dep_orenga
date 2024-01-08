/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import View_Template.Menu_Items;
import event.EventMenuSelected;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class ListMenu<E extends Object> extends JList<E> {

    private DefaultListModel model;
    private EventMenuSelected event;
    private int selectedIndex = -1;
    private int overIndex = -1;

   
    public void addEventMenuSelected(event.EventMenuSelected event){
        this.event = event;
    }
    
    
    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                  if(SwingUtilities.isLeftMouseButton(e)){
                      int index = locationToIndex(e.getPoint());
                      Object o = model.getElementAt(index);
                      if(o instanceof Model_Menu){
                          Model_Menu menu = (Model_Menu) o;
                          if(menu.getType() == Model_Menu.MenuType.MENU){
                              selectedIndex = index;
                              if(event != null){
                                  event.selected(index);
                              }
                          }
                      }else{
                          selectedIndex = index;
                          
                      }
                      repaint();
                  }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                   overIndex = -1;
                   repaint();
            }
            
            
        });
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMoved(MouseEvent e) {
                   int index = locationToIndex(e.getPoint());
                   if(index != overIndex){
                       Object o = model.getElementAt(index);
                       Model_Menu menu = (Model_Menu) o;
                       if(menu.getType() == Model_Menu.MenuType.MENU){
                           overIndex = index;
                       }else{
                           overIndex = -1;
                       }
                   }
                   repaint();
            }
            
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Menu data;
                if (o instanceof Model_Menu) {
                    data = (Model_Menu) o;
                } else {
                    data = new Model_Menu("", o + "", Model_Menu.MenuType.EMPTY);
                }
                Menu_Items item = new Menu_Items(data);
                item.setSelected(selectedIndex == index);
                item.setOver(overIndex == index);
                return item;
            }

        };
    }
    public void addItems(Model_Menu data){
        model.addElement(data);
    }

}
