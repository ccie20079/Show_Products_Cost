//<!-- easyui的datagrid宽度自适应扩展方法 -->
/*
    $.fn.extend({
         resizeDataGrid : function(heightMargin, widthMargin, minHeight, minWidth) {
          var height = $(document.body).height() - heightMargin;
          var width = $(document.body).width() - widthMargin;

          height = height < minHeight ? minHeight : height;
          width = width < minWidth ? minWidth : width;

          /*$('#wiserecordloandg').datagrid('resize', {
           height : height,
           width : width
            });
            
           }
        });
        */
/*
$(function () {
    $(window).resize(function () {
        $('#dg').datagrid('resize', {               //根据自身情况更改
            width: $(window).width() - 10,    //根据自身情况更改
           height: $(window).height() - 35  //根据自身情况更改
        }).datagrid('resize', {
            width: $(window).width() - 10,      //根据自身情况更改
            height: $(window).height() - 35   //根据自身情况更改
        });
    }); 
});
*/
function fixWidth(percent)  
{  

    return document.body.clientWidth * percent ;//根据自身情况更改

}  


/*
        $(function() {
         // datagrid数据表格ID
         var datagridId = 'wiserecordloandg';

         // 第一次加载时自动变化大小
         $('#' + datagridId).resizeDataGrid(0, 0, 0, 0);

         // 当窗口大小发生变化时，调整DataGrid的大小
         $(window).resize(function() {
          $('#' + datagridId).resizeDataGrid(0, 0, 0, 0);
         });
        });
    */