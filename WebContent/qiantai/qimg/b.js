var BDBridge = window.BDBridge || (function(){

    var self;
    var CONFIG = {
        BD_BRIDGE_OPEN : 1,
        BD_BRIDGE_ROOT : "http://qiao.baidu.com/v3/"
    };

    document.cookie = 'VERSION=2,0,0,0';
    
    if ((CONFIG.BD_BRIDGE_OPEN == 1) && (typeof window["BD_BRIDGE_LOADED"] == "undefined")) {
        window["BD_BRIDGE_LOADED"] = 1;
        var script = document.createElement("script");
        script.type="text/javascript";
        script.charset = "UTF-8";
        script.src = CONFIG.BD_BRIDGE_ROOT + "asset/js/bw.js?v=20131213";
        document.getElementsByTagName("head")[0].appendChild(script);
    }
    
    
    return self = {
    
        BD_BRIDGE_OPEN : CONFIG.BD_BRIDGE_OPEN,
        BD_BRIDGE_ROOT : CONFIG.BD_BRIDGE_ROOT,
        BD_BRIDGE_RCV_ROOT : "http://r.qiao.baidu.com/",
        BD_BRIDGE_DATA : {mainid : "120069033", SITE_ID : "999e9d8474d32c9d7302d0dcc8feacd5", siteid : "1166601", userName: 'PS-哈迈'},
        OPEN_MODULAR : 11111,
                BD_BRIDGE_SPECIAL :  [] ,
        
                BD_BRIDGE_STYLE_ITEM : 
        [        {
            pageid : "0",
            
           
                        BD_BRIDGE_GROUP:  [ '0' - 0 , '1001' - 0 , '1002' - 0 , '1003' - 0 ] ,
            
            BD_BRIDGE_ICON_CONFIG : {
                iconlvtype : "1" - 0,
                background : {
                    color : "",
                    url   : "http://qiao.baidu.com/v3/res/iconbg/02.jpg",
                    bgcolor : "#F0D9BA"
                },
                head : {
                    url    : "http://qiao.baidu.com/v3/res/iconhead/13.png",
                    width  : "147" - 0,
                    height : "70" - 0
                },
                button : {
                    color : "#f08b80",
                    url   : "",
                    text  : "#bd4b13"
                },
                flow     : "1" - 0,
                position : "2" - 0,
                special : "0"
            },
            BD_BRIDGE_INVITE_CONFIG : {
                on : "1" - 0,
                show : {
                    pos : "0" - 0,
                    width : "320" - 0,
                    height : "150" - 0,
                    font : "宋体",
                    fontsize : "12",
                    fontcolor : "#000000",
                    type : "0" - 0
                },
                background : {
                    color : "",
                    url   : "http://qiao.baidu.com/v3/res/invitebg/01.jpg"
                },
                head : {
                    show : "1" - 0,
                    size : "1" - 0,
                    url  : "http://qiao.baidu.com/v3/res/invitehead/01_big.jpg"
                },
                text   : "欢迎您，有什么可以帮助您的么？",
                button : "#f87a1a",
                mode   : "0" - 0,
                special : "0" - 0
            },
            BD_BRIDGE_INVITE : {
                inviteauto : "1" - 0,
                invitemanual : "1" - 0,
                invitetype   : "0" - 0,
                inviterepeat : "0" - 0,
                invitetime   : "30" - 0,
                invitedisaptype : "0" - 0,
                invitedisaptime : "20" - 0
            },
            BD_BRIDGE_WEBIM : {
                webimopentype : "0" - 0,
                webimbgcolor  : "",
                floatposition : "0" - 0,
                floatChatName : "2" - 0,
                floatCustomname : " "
            },
                        BD_BRIDGE_PIGEON_SOUL : {
                disableMess     : "0" - 0,
                messType        : 1,
                messFloatType   : "0" - 0,
                language        : "0" - 0,
                position        : "0" - 0,
                backgroundColor : "#6cadde",
                backgroundUrl       : "", 
                messItemName    : "0",
                messItemPhone   : "0",
                messItemAddress : "0",
                messItemEmail   : "0",
                extraMessItems  :  [] 
            }
        }        ]
        
    }
   


})();
