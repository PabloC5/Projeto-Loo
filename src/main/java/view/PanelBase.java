package view;

import javax.swing.*;
import java.awt.*;

public class PanelBase extends JPanel implements VisualWindow {

    private FrameBase frameBase;
    private CadastroVeiculo initialJP;
    private ListagemVeiculos secondJP;
    private ThirdScreen thirdJP;


    public PanelBase(FrameBase frameBase){
        this.frameBase = frameBase;
        setLayouts();
        setComponents();
        setEvents();
    }

    @Override
    public void setLayouts() {
        setLayout(new CardLayout());
        setSize(800, 550);
        setVisible(true);
    }

    @Override
    public void setComponents() {
//        initialJP = new CadastroProduto(frameBase);
//        secondJP = new Listagem(frameBase);
        thirdJP = new ThirdScreen(frameBase);
        // adicionando as telas na tela base PanelBase
        add(initialJP, "initial");
        add(secondJP, "second");
        add(thirdJP, "third");
    }

    @Override
    public void setEvents() {

    }
}