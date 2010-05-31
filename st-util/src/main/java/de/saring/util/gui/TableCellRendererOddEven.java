package de.saring.util.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Custom table cell renderer based on the default implementation. It uses
 * customizable background colors for odd and even row numbers.
 * 
 * @author  Stefan Saring
 * @version 1.0
 */
public class TableCellRendererOddEven extends DefaultTableCellRenderer {

    private Color colorBackgroundOdd, colorBackgroundEven;
    
    /**
     * Standard c'tor.
     * @param colorBackgroundOdd background color for odd rows
     * @param colorBackgroundEven background color for even rows
     */
    public TableCellRendererOddEven (Color colorBackgroundOdd, Color colorBackgroundEven) {
        this.colorBackgroundOdd = colorBackgroundOdd;
        this.colorBackgroundEven = colorBackgroundEven;
    }
    
    /** Returns the cell component for the specified value and position. */
    @Override
    public Component getTableCellRendererComponent (
        JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {

        // get component of superclass renderer, this will only be customized
        Component component = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, rowIndex, vColIndex);

        // use different background colors for all odd row numbers (not when selected)
        if (!isSelected) {
            setBackground (rowIndex % 2 == 0 ? colorBackgroundOdd : colorBackgroundEven);
        }
        return component;
    }    
}