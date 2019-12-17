package service.impl;

import dao.WaterQualityDao;
import dao.impl.WaterQualityDaoImpl;
import domain.WaterQuality;
import domain.WaterQualityStation;
import service.WaterQualityService;

import java.util.List;

public class WaterQualityServiceImpl implements WaterQualityService
{
    WaterQualityDao dao=new WaterQualityDaoImpl();

    @Override
    public List<WaterQuality> findAllByStationName(String stationName)
    {
        List<WaterQuality> allByStationName = dao.findAllByStationName(stationName);
        return allByStationName;
    }

    @Override
    public boolean addWaterQualityInfo(WaterQuality waterQuality)
    {
        return dao.addWaterQualityInfo(waterQuality);
    }
}