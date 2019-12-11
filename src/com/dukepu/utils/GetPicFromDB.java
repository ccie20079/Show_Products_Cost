package com.dukepu.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GetPicFromDB {

		static String sql = null;  
	    static DBHelper db1 = null;  
	    static ResultSet ret = null; 
	    /** 
		 * @Title: main 
		 * @Description: TODO
		 * @param args
		 * @return: void
		 */
		/*
		 * public static void main(String[] args) {
			ReadBlod2Pictures();
		}*/
		private void Test()
		{
			sql = "SELECT m.id,m.`name`,m.preview,m.`view` from itam_3d_display_model m";//SQL语句  
			 db1 = new DBHelper(sql);//创建DBHelper对象  
			 try {  
		            ret = db1.pst.executeQuery();//执行语句，得到结果集  
		            while (ret.next()) {  
		                String uid = ret.getString(1);  
		                String ufname = ret.getString(2);  
		                String ulname = ret.getString(3);  
		                String udate = ret.getString(4);  
		                System.out.println(uid + "\t" + ufname + "\t");  
		                //System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
		            }//显示数据  
		            ret.close();  
		            db1.close();//关闭连接  
		        } catch (SQLException e) {  
		            e.printStackTrace();  
		        }
		}
		/*
		private static void ReadBlod2Pictures()
		{
			//读取图片出来，保存到本地的磁盘上面  
		       sql = "SELECT m.id,m.`name`,m.preview,m.`view` from itam_3d_display_model m where m.`view` !=''";   
		       db1 = new DBHelper(sql);//创建DBHelper对象  
		       try{
		    	   ret = db1.pst.executeQuery();//执行语句，得到结果集  
		    	   while (ret.next()) {  
		    		   Blob blob = ret.getBlob("view");
		    		   String s1="E:\\imagett\\"+ret.getString(2)+".png";  
		               File file2 = new File(s1); 
		               OutputStream outputStream = new FileOutputStream(file2);     
		               outputStream.write(blob.getBytes(1,(int)blob.length()));    
		                 //打印出来的为对象     
		               System.out.println("图片名称 ："+ret.getString(2)+",图片内容: "+ blob.getBinaryStream()); 
		    	   }
		       }catch(SQLException e){
		    	   e.printStackTrace();
		       } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		       
		} 
		*/    
		   	public static String GetPicFromDB(String product_name)
			{
		   		String absPathOfPic = "";
				//读取图片出来，保存到本地的磁盘上面  
			       sql = String.format("select picture from products_picture where Product_name = '%s'", product_name);
			       db1 = new DBHelper(sql);//创建DBHelper对象  
			       try{
			    	   ret = db1.pst.executeQuery();//执行语句，得到结果集  
			    	   while (ret.next()) {  
			    		   Blob blob = ret.getBlob("picture");
			    		   //获取当前目录
			    		   String absPathOfDic = CommUtils.getRequest().getServletContext().getRealPath("/")+ "Products_Pic";
				    		   absPathOfPic = absPathOfDic + "\\" + product_name + ".jpg";
				    		   
						File file = new File(absPathOfPic); 
			               OutputStream outputStream = new FileOutputStream(absPathOfPic);     
			               outputStream.write(blob.getBytes(1,(int)blob.length()));    
			               outputStream.close();
			                 //打印出来的为对象     
			               System.out.println("图片名称 ："+product_name+",图片内容: "+ blob.getBinaryStream()); 			              
			    	   }
			    	   ret.close();
			    	   db1.close();
			    	   //return absPathOfPic;
			    	   return product_name + ".jpg";
			       }catch(SQLException e){
			    	   e.printStackTrace();
			       } catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return ""; 
			}
	}

