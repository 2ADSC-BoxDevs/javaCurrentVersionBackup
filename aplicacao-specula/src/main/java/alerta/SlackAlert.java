/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alerta;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

/**
 *
 * @author kauan.mendes
 */
public class SlackAlert {

    private static String webHookUrl = "https://hooks.slack.com/services/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";
    private static String qAuthToken = "xoxb-4236632885969-4236702067905-M7ApG54U8TqATBOaOCAeOP6M";
    private static String slackChannel = "automacao-alertas";
    
    
    public static void sendMessageToSlack(String message){   
        try{
        
    StringBuilder msgbuilder = new StringBuilder();
    msgbuilder.append(message);
    
        Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
        
            WebhookResponse wbResp = Slack.getInstance().send(webHookUrl, payload);
        
    
                    
                    
    }catch(Exception e){
        e.printStackTrace();
        
        
    }
        
    

    }}
    
    

