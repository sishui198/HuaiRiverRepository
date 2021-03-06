package web.servlet.waterLevel;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.WaterLevel;
import service.WaterLevelService;
import service.impl.WaterLevelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

@WebServlet("/UpdateWaterLevelData")
public class UpdateWaterLevelData extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String waterLevel = request.getParameter("shuiwei");
        String riverName = request.getParameter("riverName");
        String siteName = request.getParameter("siteName");
        String over = request.getParameter("chaoguo");
        String flow = request.getParameter("flow");
        String collectionDate = request.getParameter("caijiriqi");


        WaterLevel waterLevelObj=new WaterLevel();

        try {
            waterLevelObj.setId(Integer.parseInt(id));
            waterLevelObj.setWaterLevel(Double.parseDouble(waterLevel));
            waterLevelObj.setRiverName(riverName);
            waterLevelObj.setSiteName(siteName);
            waterLevelObj.setFlow(Double.parseDouble(flow));
            waterLevelObj.setOver(Double.parseDouble(over));
            waterLevelObj.setCollectionDate(Timestamp.valueOf(collectionDate+":00"));

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(waterLevelObj);

        WaterLevelService service=new WaterLevelServiceImpl();
        boolean update = service.update(waterLevelObj);

        ResultInfo info=new ResultInfo();
        if(update)
        {
            info.setMsg("更新成功！");
        }
        else
        {
            info.setMsg("更新失败！");
        }
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        this.doPost(request, response);

    }
}
