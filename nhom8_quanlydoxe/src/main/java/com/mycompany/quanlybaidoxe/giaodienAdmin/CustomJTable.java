package com.mycompany.quanlybaidoxe.giaodienAdmin;

/**
 *
 * @author trung
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class CustomJTable extends JTable {

    public CustomJTable(TableModel model) {
        super(model);
        customizeTable();
    }

     private void customizeTable() {
        // Tùy chỉnh header
        JTableHeader header = this.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 16)); // Font cho tiêu đề cột
        header.setBackground(new Color(230, 230, 250));
        header.setForeground(Color.DARK_GRAY);
        header.setPreferredSize(new Dimension(100, 40));

        // Căn giữa nội dung header
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Tùy chỉnh các ô trong bảng
        this.setRowHeight(30);
        this.setShowGrid(false);
        this.setIntercellSpacing(new Dimension(0, 0));

        // Bo góc cho bảng bằng cách vẽ nền bảng
        this.setOpaque(false);

        // Đặt renderer cho các ô
        this.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                          boolean isSelected, boolean hasFocus,
                                                          int row, int column) {
                JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                cell.setFont(new Font("SansSerif", Font.PLAIN, 13));
                cell.setOpaque(true);

                // Bo tròn cho ô
                if (isSelected) {
                    cell.setBackground(new Color(184, 207, 229));
                    cell.setForeground(Color.BLACK);
                } else {
                    cell.setBackground(row % 2 == 0 ? new Color(245, 245, 245) : Color.WHITE);
                    cell.setForeground(Color.DARK_GRAY);
                }
                cell.setBorder(new EmptyBorder(5, 5, 5, 5));
                return cell;
            }
        });
    }

}
