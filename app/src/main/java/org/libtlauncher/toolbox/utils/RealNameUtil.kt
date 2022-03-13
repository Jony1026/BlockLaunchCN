package org.libtlauncher.toolbox.Utils

import java.util.*

object RealNameUtil {

    @JvmStatic
    val realName: Array<String>
        get() {
            val ret = arrayOf("", "")
            val address = arrayOf("110000", "120000", "130000", "140000", "150000", "210000", "220000", "230000", "310000", "320000", "330000", "340000", "350000", "360000", "370000", "410000", "420000", "430000", "440000", "450000", "460000", "500000", "510000", "520000", "530000", "540000", "610000", "620000", "630000", "640000", "650000", "710000", "810000", "820000", "110100", "110101", "110102", "110103", "110104", "110105", "110106", "110107", "110108", "110109", "110111", "110112", "110113", "101114", "110115", "110116", "110117", "110200", "110228", "110229", "120100", "120101", "120102", "120103", "120104", "120105", "120106", "120107", "120108", "120109", "120110", "120111", "120112", "120113", "120114", "120115", "120200", "120221", "120223", "120225", "130100", "130101", "130102", "130103", "130104", "130105", "130107", "130108", "130121", "130123", "130124", "130125", "130126", "130127", "130128", "130129", "130130", "130131", "130132", "130133", "130181", "130182", "130183")
            val familyname = arrayOf("李", "王", "张", "刘", "陈", "杨", "赵", "黄", "周", "吴", "徐", "孙", "胡", "朱", "高", "林", "何", "郭", "马", "罗", "梁", "宋", "郑", "谢", "韩", "唐", "冯", "于", "董", "萧", "程", "曹", "袁", "邓", "许", "傅", "沈", "曾", "彭", "吕", "苏", "卢", "蒋", "蔡", "贾", "丁", "魏", "薛", "叶", "阎", "余", "潘", "杜", "戴", "夏", "钟", "汪", "田", "任", "姜", "范", "方", "石", "姚", "谭", "廖", "邹", "熊", "金", "陆", "郝", "孔", "白", "崔", "康", "毛", "邱", "秦", "江", "史", "顾", "侯", "邵", "孟", "龙", "万", "段", "漕", "钱", "汤", "尹", "黎", "易", "常", "武", "乔", "贺", "赖", "龚")
            val givenname = arrayOf("子璇", "淼", "国栋", "夫子", "瑞堂", "甜", "敏", "尚", "国贤", "贺祥", "晨涛", "昊轩", "易轩", "益辰", "益帆", "益冉", "瑾春", "瑾昆", "春齐", "杨", "文昊", "东东", "雄霖", "浩晨", "熙涵", "溶溶", "冰枫", "欣欣", "宜豪", "欣慧", "建政", "美欣", "淑慧", "文轩", "文杰", "欣源", "忠林", "榕润", "欣汝", "慧嘉", "新建", "建林", "亦菲", "林", "冰洁", "佳欣", "涵涵", "禹辰", "淳美", "泽惠", "伟洋", "涵越", "润丽", "翔", "淑华", "晶莹", "凌晶", "苒溪", "雨涵", "嘉怡", "佳毅", "子辰", "佳琪", "紫轩", "瑞辰", "昕蕊", "萌", "明远", "欣宜", "泽远", "欣怡", "佳怡", "佳惠", "晨茜", "晨璐", "运昊", "汝鑫", "淑君", "晶滢", "润莎", "榕汕", "佳钰", "佳玉", "晓庆", "一鸣", "语晨", "添池", "添昊", "雨泽", "雅晗", "雅涵", "清妍", "诗悦", "嘉乐", "晨涵", "天赫", "玥傲", "佳昊", "天昊", "萌萌", "若萌", "梓涵", "一诺", "浩字", "欣怡", "浩然", "诗涵", "宇轩", "依诺", "子涵", "欣妍", "雨桐", "字航", "梓萱", "宇泽", "可馨", "佳怡", "子萱", "子轩", "江雄", "思葭", "恩昌", "含露", "育免", "灿灿", "昊轩", "成佳", "吉明", "赛露", "培源", "亚男", "朝云", "烁新", "贤铃", "露露", "正杨", "闻潇", "朝晨", "烁星", "贤忠", "含昀", "正扬", "柳根", "星万", "薇薇", "丞邦", "泰磊", "雨坤", "肇锋", "智化", "宣烨", "俊乐", "定春", "黎晓", "高峰", "泰克", "烁苹", "灵珊", "振锋", "永锟", "泽豪", "思诚", "越洋", "熙点", "钊霖", "永昆", "思蕾", "可谦", "烁平", "熙璞", "永润", "会省", "灿柔", "烁菲", "卓成", "熙弗", "勇润", "淑林", "青莲", "菊清", "心卓", "熙清", "煦枚", "永浩", "贵凡", "文聚", "烁芝", "熙年", "铜锤", "永魁", "云霜", "烁颀", "扬洋", "榆冰", "晓江", "永年", "贵云", "泽远", "思远", "廷如", "青颐", "濡君", "玳艾", "烁荠", "洋杨", "熔巍", "海刚", "善扬", "贵霜", "烁苗", "烁芷", "雨涵", "晓春", "秋碧", "梦熊", "自力", "洋洋", "煊宇", "二喜", "世杰", "发钧", "菊云", "昶椋", "煊空", "禹冶", "文址", "梦雄", "禹征", "烁兰", "雨恒", "官正", "忆昕", "大伟", "烁古", "启椋", "煊馨", "若冶", "文潇", "智勇", "烁渊", "烁江", "落雁", "盂冶", "生富", "翠昱", "烁圆", "启茂", "煊立", "宇冶", "绮玟", "子衿", "烁谷", "烁祥", "小飞", "育冶", "梓涵", "水明", "彬彬", "兴源", "煜恒", "翔坤", "波繁", "俊贤", "菊荣", "烁坍", "若西", "翔昆", "姿霖", "润东", "烁词", "烁攸", "贝津", "翔琨", "秀军", "东阳", "烁诗", "同跃", "若惜", "翔锟", "标锋", "贵灿", "烁蔻", "烁姣", "焯依", "瑜雅", "舜楠", "同霏", "洪旭", "烁娇", "焯越", "昱雅", "超琪", "童霏", "敏敏", "烁宁", "玉希", "禹雅", "贤岐", "垠炜", "烁雅", "烁鸣", "克熙", "裕雅", "贤泽", "雨童", "烁梦", "烁铭", "露茜", "宇雅", "瑾彤", "泽坤", "烁歌", "烁名", "露熙", "于雅", "文萱", "鹏飞", "烁鸽", "烁明", "熙嫒", "欲雅", "政儒", "建生", "永生", "烁荥", "仁杰", "育雅", "士庆", "曼青", "烁辉", "烁青", "熙照", "毓冶", "碧华", "曼华", "烁蕙", "烁庆", "熙励", "煜雅", "洁冰", "传海", "秀俊", "烁庭", "烁坤", "育野", "庆亮", "曼贞", "烁惠", "烁音", "淼帆", "宇野", "新欣", "辰益", "晓华", "煜玎", "晓静", "盂珉", "煜平", "国霖", "烁泉", "煜冬", "源澧", "盂民", "华虹", "长会", "欣潼", "灵玎", "源礼", "盂敏", "友光", "晨益", "心潼", "灵佟", "坤灿", "盂腼", "孟鑫", "曼霏", "烁春", "灵彤", "冰云", "盂缅", "孟娴", "佳鑫", "喜喜", "伶俐", "春霖", "盂绵", "琬鑫", "泽东", "烁学", "烁玎", "傲天", "盂棉", "远欣", "佳忻", "烁习", "烁定", "一萱", "宏荣", "易穸", "美凤", "咏淇", "林骤", "彦铮", "盂冕", "展宇", "嘉欣", "心如", "烁东", "天野", "盂勉", "跃宣", "岳儿", "烁溪", "烁冬", "一钒", "盂免", "自琪", "明烨", "烁柔", "烁佟", "依凡", "毓免", "桐宇", "鹏程", "烁揉", "自驴", "卓铮", "瑜免", "佟宇", "家龙", "佳青", "烁童", "三满", "寓免", "传振", "雨忻", "咏颀", "谨言", "玉铮", "榆免", "薏曦", "雨昕", "冯昊", "烁肜", "婕妤", "渝免", "春雷", "少华", "烁箐", "烁绒", "丽钦", "喻免", "跃煊", "雨锌", "咏绮", "宗方", "浩峻", "虞免", "苡曦", "晓秋", "仕森", "烁彤", "婕娇", "于免", "良平", "京晟", "烁舟", "烁丹", "俊阳", "逾免", "自淇", "雪儿", "文俊", "怀木", "文景", "余免", "俊杰", "雨馨", "咏琦", "陌恬", "娇皎", "余绵", "思琦", "雨欣", "烁彩", "烁京", "雯瑾", "俞绵", "俊平", "晓聪", "咏琪", "遵功", "禺霆", "俞棉", "晓峰", "雨霏", "美滋", "烁今", "皆娇", "俞敏", "玉斌", "思纤", "美贤", "烁静", "劭晗", "俞勉", "易茜", "国林", "烁渠", "获戎", "韭葡", "祥锟", "能权", "昕祺", "蜜儿", "烁点", "昱鹏", "俞免", "奇展", "艳平", "烁黛", "烁烁", "玉鹏", "祥琨", "长绵", "彩虹", "建豪", "纵殿", "俊儿", "妤勉", "能贤", "根地", "丽坤", "烁田", "奕娈", "俞冕", "易羲", "耕地", "迎第", "佳梦", "瑾雯", "语冕", "思淇", "恒睿", "小骞", "梨殿", "家宣", "育棉", "能芹", "琼辉", "烁韬", "碧芮", "佳煊", "育绵", "诗淇", "峥嵘", "烁慈", "烁仪", "文宪", "语勉", "易玺", "铭涛", "佳人", "德各", "爱霜", "钰勉", "灿青", "国范", "烁瑜", "弋惜", "杞泉", "毓勉", "晶灿", "雨珊", "烁钰", "烁斡", "伊丸", "毓雅", "易曦", "恒愉", "晓骞", "耀光", "伊惋", "跃轩", "良伟", "岳峨", "烁雨", "熔纯", "伊婉", "跃先", "嘉歆", "月峨", "烁韵", "烁莞", "伊倪", "妤免", "柏源", "月俄", "烁曼", "光耀", "世永", "钰免", "贤琦", "恒瑾", "烁蔓", "烁果", "静蕾", "耀煊", "星际", "奕佶", "烁婉", "光生", "诗雨", "郁免", "乐为", "红雨", "春华", "烁艺", "雨诗", "宇免", "星凡", "雨谖", "烁荔", "归各", "语诗", "语免", "涵韵", "奕祁", "烁玫", "畅纯", "诗语", "耀先", "星瑞", "奕奇", "定高", "泳川", "诗蔓", "予免", "承瑞", "金蓬", "谨帆", "烁天", "诗汇", "玉免", "能帮", "爱雨", "强午", "正熙", "雨林", "海茏", "广瑞", "越儿", "玉莲", "径纲", "雨龄", "育闵", "子瑞", "瑾旖", "烁阳", "桂鲜", "一秒", "嫒茏", "俊贞", "雪滢", "强旭", "廷浩", "淼淼", "育苠", "瑞骐", "昌雨", "沁信", "径葡", "雨鄢", "瑷茏", "艺涵", "霜霏", "煦玎", "劲广", "跃军", "育玟", "松源", "奕辉", "煦冬", "林过", "俊磊", "皑茏", "涵艺", "秋雨", "信烽", "笠各", "欣奇", "育敏", "瑞涛", "睿嘉", "煦彤", "一举", "欣淇", "育民", "艺璇", "梦雨", "烁弈", "木笔", "艺聆", "育冕", "方元", "潇霏", "烁声", "祟朋", "亿南", "瑷侬", "玉华", "晓霏", "建峰", "承坤", "含芝", "皑侬", "瑞天", "瑾璐", "柯菲", "嘉瑞", "康楠", "灵相", "治衡", "奕伟", "紫涵", "舒禾", "永铮", "灵齐", "道春", "渊过", "济凡", "舒畅", "永政", "灵骐", "昱轩", "松辉", "欣雨", "思禹", "昆山", "灵贵", "佩慈", "雪霖", "骐凡", "俊灿", "佩耘", "雨宵", "致轩", "绮娴", "军荣", "舒涵", "姝慧", "灵华", "治轩", "雨霖", "沁音", "晟萱", "家慧", "灵册", "汉琦", "雨淋", "宝星", "舒含", "雨佳", "灵源", "海东", "雨晨", "若菡", "若诗", "启楷", "毅权", "新连", "雨露", "奇谦", "妙语", "晓斌", "灵果", "治均", "松良", "贵晶", "语珠", "启槐", "昆明", "少烽", "奕讳", "春龙", "连钢", "启桓", "灵丫", "大畏", "雨龙", "炎翰", "凤鸣", "启檐", "源清", "沁姝", "振海", "嫦熙", "瑞璐", "韦违", "亦权", "金荣", "奕焕", "俊城", "玉云", "风光", "亦隽", "泽然", "奕怀", "亦舫", "宁宁", "雪慈", "俊州", "科泽", "歆愉", "宜宸", "文成", "启桢", "灵青", "利国", "奕杭", "信维", "嘉璐", "依盈", "丽柯", "多洵", "奕航", "绍涵", "琼晓", "永奎", "明福", "妤桐", "奕瀚", "河伯", "玉娣", "臣镭", "灵珍", "映蝶", "永甲", "贤国", "茗雨", "舒宁", "君柯", "坤璧", "思恩", "彦汐", "梦杰", "益宁", "灵阁", "清宜", "晓彤", "晟榕", "根生", "永正", "灵祝", "锦益", "晓童", "志澍", "梦飞", "根华", "灵庆", "渝平", "海滟", "洪澍", "建伟", "政成", "灵如", "童生", "海雁", "涌澍", "家传", "超宁", "灵月", "泽铭", "海彦", "超澎", "琼乐", "子妮", "梦柯", "长林", "忻昕", "远鑫", "安诸", "姝瑾", "灵宛", "高明", "穆君", "瑞琪", "一乐", "敏强", "灵璞", "晓野", "海鬓", "晟源", "琪乐", "敏慧", "灵秋", "国凤", "海髌", "殿刚", "其乐", "柏岑", "灵丰", "天拙", "木君", "懂斌", "子静", "柏言", "灵慧", "施漫", "海镔", "江澎", "润笔", "一鸣", "灵葳", "天随", "沐君", "昊晟", "若萱", "思佚", "灵康", "天粲", "海膑", "八十", "丽爱", "艺茁", "昌硕", "子昂", "海殡", "胤妗", "坤芮", "敏优", "灵淇", "子轩", "海缤", "诺言", "丽辰", "善岩", "相志", "佳睿", "海豳", "格言", "丽讯", "宇豪", "道子", "银珠", "海彬", "格格", "牧信", "颖心", "灵珏", "碎林", "海摈", "红云", "敏惠", "发林", "章辉", "海颜", "桃梓", "红星", "春凤", "灵攀", "永山", "海濒", "桃婕", "荣礓", "炳林", "灵蝰", "屁屁", "海槟", "欣然", "叶群", "建林", "昌函", "花朵", "伟亚", "桃子", "宜姝", "炳海", "灵祈", "轩哲", "海涛", "乐倪", "海灵", "美佳", "治宏", "杜伟", "慕军", "一森", "俊凤", "美嘉", "灵儿", "绮绮", "海滨", "兢伟", "笛毓", "宇辰", "延俊", "晓进", "万安", "大歪", "秀兰", "振宏", "延飞", "雯尧", "安树", "乐儿", "茜穗", "方正", "呵谖", "丽俐", "轩子", "晓凯", "思逸", "焕林", "灵芝", "晖晖", "宣子", "世民", "逸彤", "艺卓", "灵艺", "佩容", "亚霖", "泽惠", "思彤", "朝成", "灵乐", "益帆", "艳菁", "文雅", "艳秀", "传仁", "光喜", "晓庆", "雪峰", "舒雅", "泓江", "传哲", "灵铢", "正元", "碧波", "尔雅", "矜芝", "杭云", "灵蕊", "振元", "桂晶", "桂珍", "姝纾", "善平", "晓刚", "正圆", "慕君", "国华", "春倪", "嘉嘉", "灵坤", "惠华", "官尚", "宇斌", "秋真", "伟君", "灵伶", "丹阳", "顺虎", "昊晖", "来强", "朝万", "小刚", "鹭鹭", "家骏", "新建", "飞鸿", "传达", "春蝶", "日余", "明珠", "昱灿", "天靖", "寿龙", "箐伶", "洪新", "凤祥", "文瑾", "宝庆", "玉航", "凤彩", "雅芝", "兴军", "玉雯", "丽泓", "雨函", "孔森", "裕青", "万宝", "昊烨", "洁璇", "孔生", "贞蕊", "舒虹", "志腾", "妙歌", "以晴", "兰运", "孔樟", "海佩", "炳毅", "潇滨", "宝钻", "凤兰", "姣珏", "蓓蓓", "伯焱", "凌云", "小优", "乐源", "菡藕", "佩佩", "炳言", "凌如", "小涵", "嫒鹳", "佳航", "培芝", "子武", "晓成", "梦骊", "泽君", "孔楹", "佩芝", "念宗", "静静", "晓骊", "家俊", "荻坤", "亦萱", "伯金", "雨潞", "芸涛", "栋声", "煅坤", "雅华", "积云", "昱佟", "麟煜", "易泳", "飞荣", "天官", "水鱼", "韵如", "焰骊", "正峰", "烃坤", "军莲", "馨瑜", "同凇", "海飞", "佑天", "煌坤", "春乔", "极云", "语欣", "有信", "乾仔", "润坤", "毅然", "雨鑫", "昊佟", "豫骊", "志天", "打渝", "灿心", "隐轩", "含韵", "振明", "志丹", "月仙", "正气", "旭诺", "金成", "雨珂", "思凝", "定坤", "灿欣", "小平", "伦笔", "松涛", "姝峤", "显吉", "水龙", "佳晔", "伦比", "秀伟", "祉颐", "孟蟠", "颜苒", "佳昌", "同凌", "袁剑", "连华", "美萱", "烟然", "佳旭", "美伦", "雄伟", "奕晨", "煌珏", "灿霜", "佳晨", "满伦", "友发", "纯柔", "孔楠", "昕坤", "楠娇", "美人", "雨乐", "沂璇", "思青", "寻欢", "浩瑜", "浚卯", "琪萱", "金华", "梦君", "泽海", "晨诺", "姬乐", "新中", "锦柯", "煌女", "晶碧", "宇凡", "姬舒", "彦辉", "宇福", "青思", "品灼", "钟鸣", "晟玮", "静蟾", "柯格", "荧凤", "景涛", "佳诺", "思钰", "静禅", "兆楠", "荧彩", "玉祥", "佳锘", "炅晔", "喜朝", "军保", "梦迪", "昕宇", "佳锣", "其舒", "思静", "寿东", "孔贤", "品仪", "佳洛", "舒惠", "明贵", "寿乐", "孔泉", "鑫来", "姗姗", "涤容", "艳华", "子鸿", "孔清", "正亚", "晨兴", "梅兰", "生闻", "灵奇", "善穹", "缺陷", "嘉乐", "智书", "文斌", "灵贝", "玉山", "承泽", "晨乐", "舒韵", "宏涛", "灵熹", "高杰", "颜然", "金晨", "爱如", "永钲", "清朗", "宗宪", "宇阔", "雨哲", "嘉如", "俊生", "灵碧", "万侃", "影影", "睿贤", "嘉禾", "丽虹", "灵潭", "侃万", "金仪", "向哲", "俊炀", "永怔", "灵湘", "吉育", "海波", "灯金", "明良", "千子", "玟敏", "如兰", "晨晨", "其荣", "子全", "翠芸", "玟珧", "侍迦", "士宏", "疏影", "佟晨", "昊博", "布衣", "楚桐", "伟群", "楚烟", "毅恒", "晓鸣", "明友", "骁龙", "锡华", "先哲", "煜哲", "子千", "俐敏", "卓桐", "丹滢", "天戈", "子龙", "学东", "炒苗", "品淳", "朋建", "楚秋", "思融", "晓新", "妨彗", "健功", "志敏", "秋际", "志贞", "翠云", "伶麦", "俊良", "仁宝", "其桦", "吕明", "若棠", "帆苗", "诗伽", "延华", "炳贤", "鸿斌", "春勇", "栩洲", "诗嘉", "晨曦", "其晔", "龙驰", "勇福", "兆苗", "诗佳", "佳麒", "其烨", "海君", "民丰", "兆珧", "世军", "林营", "善学", "美金", "嘉佳", "彤新", "灵渝", "睿临", "彬君", "忠桥", "琦雯", "岱芸", "晓利", "瑞临", "若愚", "谚希", "欣诺", "金穗", "灵煜", "志远", "沐香", "钟桥", "小川", "栩佛", "静桐", "瑞麟", "若有", "建臻", "沐泽", "聆敏", "诗葭", "骏亮", "风雨", "乐天", "忠平", "珧珧", "驰龙", "骏麟", "啸天", "江钏", "义茂", "栩尧", "羡勋", "思宇", "司翊", "建增", "文锋", "海珧", "灵灵", "冻并", "沐圆", "红宝", "方宝", "兆麦", "清涛", "和平", "定远", "伟杰", "汉兴", "栩泽", "金龙", "宇龙", "沐原", "洁雨", "华龙", "妃敏", "年青", "冰亮", "英正", "子杰", "顺财", "栩东", "为龙", "羽桐", "海绕", "晓亮", "荣超", "嘉键", "毅龙", "榆桐", "汝亲", "紫锦", "春伟", "栩儒", "兆建", "昊袄", "沐亲", "汝秋", "铁军", "爱华", "仲博", "焯淇", "瑞龙", "亚桐", "建萌", "曼海", "子墨", "晓桐", "沐家", "止境", "天然", "栩孔", "家麒", "维君", "沐嘉", "淮水", "牡丹", "析丞", "国梁", "亦衍", "沐佳", "雅桐", "家欣", "天黎", "家琪", "亦含", "沐兰", "泽楷", "佳欣", "从元", "丽新", "雨彬", "沐蓝", "铭宇", "炳辉", "轶平", "海宁", "爰彻", "炎国", "云桐", "佳晴", "舸澜", "官潢", "多涵", "沐梵", "桐桐", "佳敏", "淄玺", "建国", "雨静", "伟宏", "桐同", "保藩", "纯勇", "家豪", "柏苇", "仙凤", "楚君", "天虞", "国豪", "国正", "国新", "沐凤", "刚伦", "陶然", "丹邱", "佳豪", "子叶", "伟瀚", "晓波", "靖轩", "宜梵", "国政", "恬恬", "沐仪", "俊熙", "洋帆", "邦国", "家毫", "秋实", "士涵", "立涛", "晋锋", "一梵", "国浩", "悠然", "晓璐", "康平", "建辉", "国庆", "利新", "文翰", "清镜", "诚彬", "贝儿", "宴诚", "国亮", "云旗", "伟沆", "纲仑", "苏玛", "雨芯", "佳奇", "佐桂", "加勉", "昌志", "丝羽", "雨莘", "佳琪", "鸣飞", "泽仁", "纲纶", "大建", "志银", "煜正", "金坤", "欣为", "思佳", "斯誉", "婉礤", "清跃", "梓梁", "沁园", "云娣", "斯于", "一佳", "清越", "仕杰", "沁圆", "子衅", "剑辉", "一末", "圣威", "仕远", "凤沁", "思影", "文静", "傲国", "传敏", "仕元", "凤清", "梓心", "思雨", "彤禹", "金朔", "昀琰", "清凤", "晨光", "学康", "彤宇", "泽月", "元楷", "志龙", "丛雨", "思语", "国楠", "国通", "元杰", "佳皓", "梓欣", "学军", "帅杭", "彤月", "杰元", "清涟", "聪伟", "凌峰", "鹏锋", "瑞月", "定元", "嘉勉", "瀚宇", "潮飞", "智敏", "定广", "杰远", "凤仪", "小清", "一桂", "润杭", "龙虎", "昀远", "阵山", "淼水", "晓勃", "世发", "定邦", "定先", "明兴", "积远", "小丫", "文童", "颖月", "定怿", "丽瑞", "韵竹", "妮丫", "陈禹", "颖越", "怿远", "振杉", "银生", "雅妮", "醒方", "贞贞", "彦祖", "稹山", "勇佳", "逸凡", "宜杭", "琼月", "奇恩", "季伦", "勇辉", "磐若", "适中", "月玫", "拓恩", "付新", "勇康", "曼延", "勉信", "梅月", "英恩", "琼恬", "勇桂", "曼钰", "清华", "海月", "若恩", "秀微", "寅生", "研迪", "宪立", "宽军", "抗恩", "世钢", "勇吉", "林霖", "佳一", "东生", "坤恩", "小丹", "勇杰", "非嫔", "建益", "已繁", "诩恩", "丹丹", "珈仪", "敖晨", "哲然", "冬生", "京恩", "南松", "思畅", "昊龙", "新增", "乙凡", "来恩", "元衡", "晓翠", "颖侠", "煜琛", "海丹", "佩恩", "佳民", "纲伦", "甲楠", "小楠", "昊宇", "承恩", "勉勤", "晓珍", "漫演", "孝楠", "乙繁", "亟远", "芷轩", "载德", "贺侠", "舒棋", "泳仪", "函远", "芷靖", "小珍", "承志", "少楠", "熠繁", "秉远", "泓睿", "弈樊", "漫漩", "熙然", "英垲", "非远", "小鱼", "佳佳", "宸智", "晓楠", "晓岚", "东远", "佳浩", "思蝉", "淑魅", "禹楼", "显兰", "协远", "建烈", "亦来", "海影", "润欣", "德贵", "长远", "中兰", "万喜", "坤苑", "政谦", "烨茗", "雨远", "沛洪", "生杰", "与伦", "浩宇", "晓蕊", "忠刚", "材攀", "伟凡", "雯魅", "侃明", "雅宁", "贤远", "锁珍", "翊凡", "末柏", "国荣", "易天", "志静", "佳霖", "晓川", "雯慧", "小昕", "熠凡", "昊远", "丹君", "翊樊", "勇清", "永金", "克楠", "定楷", "世刚", "思涵", "丁楠", "常永", "睿菁", "梅君", "佳轩", "炯圣", "涵绵", "方昊", "椿毅", "集宽", "晶晶", "恒毅", "金泽", "伟康", "海光", "名华", "佳恩", "航桐", "海申", "伟健", "晓良", "远兮", "佳松", "正华", "麦苗", "伟秋", "信宽", "木荣", "硕果", "海哂", "秋旭", "银华", "屈心", "家宝", "凤平", "思菲", "瑞祥", "雅森", "先忧", "泓兴", "福盛", "苗苗", "炫松", "晓宏", "定栩", "镇坤", "欣恬", "思秀", "晓榕", "佩凝", "先栩", "轶诚", "钰祁", "俳苗", "伟青", "极楠", "子羽", "惊涛", "浩博", "妃菲", "煊泽", "逸泉", "若栩", "泓璋", "有宝", "森淼", "旯荔", "明毅", "子灵", "脾气", "菁菁", "玫涓", "瑞民", "红苗", "其栩", "月亮", "欣桐", "玫海", "悠悠", "希华", "雪灵", "永贵", "有成", "思成", "宇翔", "卫群", "其柏", "炜莹", "鸿婷", "浩莹", "蕊娟", "瑛瑛", "宪玉", "柯颖", "栩悦", "悦颖", "钰玲", "晓悦", "红洁", "濠莹", "悦瑜", "越颖", "培洁", "倩红", "昭萍", "婷贝", "妙倩", "跃颖", "锐洁", "倩茹", "芝萍", "泯艳", "洪文", "晶莹", "淼洁", "蕙文", "怡菲", "湘怡", "雁琴", "沛瑛", "壑洁", "惠文", "远芳", "楚娅", "雨悦", "沛颖", "菏洁", "月梅", "素花", "泯瑶", "妍傧", "沛英", "钰霞", "曼妞", "耀娟", "泯莹", "如雪", "江瑶", "蕊洁", "凯丽", "怡坤", "沛倩", "朝英", "裴妍", "磊洁", "羡娜", "怡杰", "泯红", "柳花", "沛妍", "蕾洁", "淑娜", "卿丽", "泯娟", "娇玉", "筱悦", "磊娟", "莹洁", "清丽", "凯莉", "志燕", "瑶瑶", "蕾娟", "家颖", "玺琴", "泯莉", "青红", "高悦", "妍萍", "易玲", "颖红", "锦怡", "书玉", "怡秋", "彩芳", "逍瑶", "文文", "丽雪", "如玉", "淑媛", "尚文", "皓文", "怡宁", "奇娟", "赛娅", "妍芷", "蔓莹", "烙妍", "铁英", "姝婧", "茶花", "嘉媛", "燕烽", "佩琴", "少英", "红妹", "长琴", "乐媛", "炫颖", "秋文", "潇冉", "幼玲", "华娟", "健英", "肖玲", "荣花", "瑶黥", "岱蓉", "琴琴", "鉴玲", "振雪", "显梅", "柔颖", "林洁", "焕英", "碧瑛", "洋雪", "铠莹", "怡洁", "秀催", "娅妮", "妍瑶", "洋玉", "冰莹", "芷颖", "秀颐", "斌燕", "妍瑜", "曦文", "紫怡", "亚洁", "志娜", "喜娟", "妍谕", "小倩", "筱娜", "志芬", "子萍", "亭瑶", "妍漫", "幸妍", "孟洁", "幼茹", "娅杉", "梦冉", "忻莹", "红丽", "高洁", "蔚芬", "玲慧", "士萍", "忻颖", "杰婷", "婷如", "江妍", "宏霞", "婧淳", "素文", "雪萍", "璧琼", "江怡", "姝婷", "元倩", "妹英", "太芳", "咏蓉", "安瑶", "玲君", "广文", "怡煜", "秒倩", "静婷", "欣莹", "琼琼", "美芬", "洋琴", "家茹", "利红", "瑶晗", "厚琼", "紫玉", "炜玲", "静茹", "惠琼", "爱琴", "永艳", "怡佳", "苏琴", "金英", "钊莹", "月婷", "伦燕", "世文", "冬雪", "青玉", "焯莹", "珠玉", "毅倩", "朝怡", "旭霞", "丹萍", "先丽", "皓悦", "根妹", "奕倩", "美文", "乐萍", "海瑛", "淑萍", "继芳", "圆琴", "琳涵", "艳燕", "太琴", "凯悦", "昌艳", "洳雪", "涵雪", "悦萍", "陆娟", "叶萍", "向洁", "丽燕", "燕琳", "越萍", "博妍", "玉英", "婵盈", "高瑶", "梦琳", "正梅", "泽瑶", "开颖", "婵颖", "焱婷", "罗丽", "荣丽", "湘梅", "开悦", "婵嬴", "茹亚", "延霞", "玲利", "倩玲", "伊娜", "婵莹", "桂琴", "莲芳", "明洁", "新美", "奇燕", "娅莉", "永琴", "芷娟", "承颖", "美悦", "寒芬", "福英", "盈洁", "莹", "惠英", "佳婵", "佘倩", "憾悦", "颖洁", "彦婵", "长娥", "昭莹", "燕花", "婵滢", "滢洁", "治英", "海娥", "新悦", "文美", "雅玲", "继玲", "婉琼", "怡翰", "秋莹", "风琳", "禄萍", "轶红", "少娥", "倩阁", "鹤萍", "怡祯", "贺英", "婵妤", "连芳", "静英", "小洁", "浮萍", "宜婷", "健霞", "沭婵", "丽婵", "翠莹", "佛萍", "燕敏", "明娟", "沭瑶", "楚玉", "巧芬", "云萍", "秋颖", "琴芳", "扬雪", "利英", "明瑶", "紫萍", "秀璇", "勤芳", "天雪", "秀美", "燕群", "芷萍", "敏莉", "灿红", "正雪", "觊倩", "荔丽", "熹萍", "旭文", "玲萱", "钥怡", "浣文", "桂花", "说萍", "益玲", "远芬", "子颖", "锡梅", "赛萍", "碧萍", "碧丽", "筱颖", "素蓉", "华丽", "智萍", "紫莹", "燕雅", "坚文", "燕瑾", "娅楠", "练红", "璀萍", "绍红", "利美", "予文", "映霞", "志萍", "翡萍", "明芬", "裕文", "予玉", "艳婷", "敏洁", "泺萍", "怡慧", "郝洁", "施颖", "聿瑶", "莉", "水玲", "泓文", "杭颖", "轶萍", "财丽", "潞萍", "军颖", "寒美", "杭燕", "怡葶", "珊洁", "漾萍", "惠玲", "河洁", "纪燕", "怡缃", "孝莉", "扬萍", "蕙玲", "睿文", "佳倩", "怡莹", "彦娜", "央萍", "珠萍", "家文", "瑞婷", "爱红", "水洁", "论萍", "彦文", "丹艳", "洪芳", "瑞洁", "国梅", "忝萍", "琰芳", "坤霞", "迁芬", "祥文", "郦洁", "腆萍", "宏文", "伟琳", "焯玲", "小冉", "允英", "恬萍", "少玲", "梅琳", "一妍", "晨悦", "泽蓉", "添萍", "茵萍", "千红", "方媛", "芊怡", "洁霞", "田萍", "迪文", "亮颖", "淇莹", "菲艳", "霞洁", "甜萍", "燕凌", "蓓莉", "均琳", "茹依", "彤洁", "婉萍", "颖媛", "翌红", "佳雪", "妍凝", "煦文", "茹萍", "国萍", "良艳", "刚玉", "妍萱", "韵花", "酾倩", "振娟", "雨霞", "玉芬", "悦娴", "湘莹", "欢萍", "辉娜", "莉亚", "彬霞", "悦慧", "子莹", "筠萍", "艳莉", "洪燕", "烨霞", "春冉", "丽花", "纭萍", "金燕", "希怡", "艳霞", "贞萍", "袁萍", "蕴萍", "道霞", "洪霞", "杏霞", "月妹", "秀辰", "萍妹", "政霞", "长英", "悦合", "嫣语", "婕玲", "不萍", "钰瑶", "穗怡", "桢琳", "满英", "晔文", "见萍", "羽瑶", "凤莹", "禾悦", "雨妍", "翊文", "萍之", "玉瑶", "诚媛", "悦和", "语妍", "沂文", "萍芝", "雨瑶", "诚颖", "悦河", "烈英", "文艳", "之萍", "旭茹", "诚婷", "悦何", "洪婷", "八莹", "惠萍", "青莹", "沭蓉", "秀禾", "宏婷", "林梅", "江萍", "雅娥", "良梅", "悦禾", "红婷", "珏洁", "桃萍", "美玉", "良琼", "钐娜", "心洁", "姚美", "东萍", "俪娟", "良丽", "瑞美", "灵丽", "君洁", "高萍", "妤蓉", "礼红", "筱梅", "美艳", "昭蓉", "姝萍", "汶倩", "仪红", "玲娟", "洋悦", "昭怡", "漱萍", "雨琴", "敏莹", "琳娟", "琴华", "雨娟", "舒萍", "妮娜", "淑红", "倩莉", "燕开", "钥萍", "春萍", "培秀", "新玲", "倩丽", "健芬", "冰红", "竟萍", "天文", "慕红", "冠颖", "金婷", "燕葵", "竞萍", "荭婷", "楚梅", "倩如", "含玉", "柔萍", "镜萍", "弘婷", "建梅", "蕊倩", "若琳", "斯琴", "全红")
            val random = Random()

            //随机名字
            ret[0] = familyname[random.nextInt(familyname.size - 1)] + givenname[random.nextInt(givenname.size - 1)]

            //随机身份证
            var str = ""
            val rid = StringBuilder()
            rid.append(address[random.nextInt(address.size - 1)])
            rid.append(19)
            rid.append(70 + random.nextInt(29))
            rid.append(fullzero(1 + random.nextInt(11)))
            rid.append(fullzero(1 + random.nextInt(25)))
            rid.append(random.nextInt(9))
            rid.append(random.nextInt(9))
            rid.append(random.nextInt(9))
            str = rid.toString()

            //校验
            val coeff = intArrayOf(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1)
            val suffix = arrayOf("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2")
            var sum = 0
            for (i in 0..16) {
                sum += coeff[i] * (charCodeAt(str, i) - 48)
            }
            sum %= 11
            str = str.substring(0, 17) + suffix[sum]
            ret[1] = str
            return ret
        }

    fun charCodeAt(str: String, i: Int): Int {
        return str[i].toInt()
    }

    fun fullzero(num: Int): String {
        val n = "" + num
        return if (n.length == 1) {
            "0$n"
        } else {
            n
        }
    }
}