package offer.Threadlr;

/**
 * Created by zack.lr on 2017/7/12.
 */
public class TestThread2 {

    public static void main(String[] args) {
        /*List<ProductPop> list = productDao.getProudctList(map);
        if (list.size() > 0) {
            Map<String, Object> map2 = new HashMap<String, Object>();
            List<String> proList =new ArrayList<String>();
            for (int i = 0; i < list.size(); i++) {
                ProductPop productPop = list.get(i);
                proList.add(productPop.getProduct_id());
                if (searcher!=null) {
                    map2.put("status", searcher.getStatus());
                }
            }
            map2.put("products_id",proList);
            List<GoodsPop> goodsPop = productDao.queryGoodsList(map2);
            for (int i = 0; i < list.size(); i++) {
                ProductPop productPop = list.get(i);
                List<GoodsPop> goodsPopList=new ArrayList<GoodsPop>();
                for (GoodsPop goodsPop2 : goodsPop) {
                    if (productPop.getProduct_id().equals(goodsPop2.getProducts_id())) {
                        goodsPopList.add(goodsPop2);
                    }
                }
                productPop.setGoodsList(goodsPopList);
            }
        }
        return list;
    }


    public void testThread(){
        List<ProductPop> list = productDao.getProudctList(map);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ProductPop productPop = list.get(i);
                Map<String, String> map2 = new HashMap<String, String>();
                map2.put("products_id", productPop.getProduct_id());
                if (searcher!=null) {
                    map2.put("status", searcher.getStatus());
                }
                List<GoodsPop> goodsPop = productDao.queryGoods(map2);
                if (goodsPop!=null&&goodsPop.size()>0) {
                    for (int j = 0; j < goodsPop.size(); j++) {
                        GoodsPop gPop=goodsPop.get(j);
                        Integer showQuality = 0;
                        if (gPop.getSku()!=null&&!"".equals(gPop.getSku())) {
                            List<AtpQueryStock> gStockList = productDao.queryGoodsStockByGidAndWhId(gPop.getSku());
                            if(gStockList!=null&&gStockList.size()>0){
                                showQuality = new Integer(gStockList.get(0).getAvailableQty());
                            }
                        }
                        gPop.setShow_quantity(showQuality);
                    }
                }

                productPop.setGoodsList(goodsPop);
            }
        }*/
    }
}
