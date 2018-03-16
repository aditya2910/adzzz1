package com.demo.report.reportpoc.test5;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.BorderBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class CollectionDatasourceReport {
	public CollectionDatasourceReport() {
		   build();
		}
		private void build() {
			StyleBuilder columnHeaderStyle = stl.style()
                    .bold()
                    .setBackgroundColor(Color.LIGHT_GRAY)
                    .setBorder(stl.pen1Point())
                    .setHorizontalAlignment(HorizontalAlignment.LEFT);

					
			JasperReportBuilder report = DynamicReports.report();
			report
				.columns(
	                  col.column("Item", "item", DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT).setTitleStyle(columnHeaderStyle),
	                  col.column("Quantity", "quantity", DataTypes.integerType()).setHorizontalAlignment(HorizontalAlignment.LEFT).setTitleStyle(columnHeaderStyle),
	                  col.column("Unit price", "unitPrice", DataTypes.bigDecimalType()).setHorizontalAlignment(HorizontalAlignment.LEFT).setTitleStyle(columnHeaderStyle))
				.setDataSource(createDataSource())
				.title(
						Components.text("SimpleReportExample")
						  .setHorizontalAlignment(HorizontalAlignment.CENTER))
						  .pageFooter(Components.pageXofY());
			
			try {
				report.show();
				report.toPdf(new FileOutputStream("/Users/adityakumar/Desktop/delete/poc/report-poc/src/main/resources/reports/report.pdf"));
				//report.toCsv(new FileOutputStream("/Users/adityakumar/Desktop/delete/poc/report-poc/src/main/resources/reports/report.csv"));
			} catch (DRException | FileNotFoundException e) {
				e.printStackTrace();
			}

		}

		private JRDataSource createDataSource() {
		   List<Data> data = new ArrayList<Data>();
		   
		   data.add(new Data("DVD", 5, new BigDecimal(30)));
		   
		   data.add(new Data("Book", 8, new BigDecimal(11)));
		  
		   data.add(new Data("PDA", 2, new BigDecimal(15)));
		   return new JRBeanCollectionDataSource(data);
		}
		
		
		public static void main(String[] args) {
		   new CollectionDatasourceReport();
		}
		
		
		public class Data {
		   private String item;
		   private Integer quantity;
		   private BigDecimal unitPrice;
		   public Data(String item, Integer quantity, BigDecimal unitPrice) {
		      this.item = item;
		      this.quantity = quantity;
		      this.unitPrice = unitPrice;
		   }
		   public String getItem() {
		      return item;
		   }
		   public void setItem(String item) {
		      this.item = item;
		   }
		   public Integer getQuantity() {
		      return quantity;
		   }
		   public void setQuantity(Integer quantity) {
		      this.quantity = quantity;
		   }
		   public BigDecimal getUnitPrice() {
		      return unitPrice;
		   }
		   public void setUnitPrice(BigDecimal unitPrice) {
		      this.unitPrice = unitPrice;
		   }
		   
		}

}
