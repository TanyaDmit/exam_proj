package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalMessage;
import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.entity.PostalPackage;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FileController {

    private PrintWriter fileWriterData = new PrintWriter(new FileWriter("output_data.txt", true));
    private PrintWriter fileWriterMessage = new PrintWriter(new FileWriter("messages.txt", true));

    public FileController() throws IOException {
    }

    public void writePostalClient(List<PostalClient> postalClient){
        for(int i = 0; i < postalClient.size(); i++){
            fileWriterData.print("client : " + postalClient.get(i).getLoginClient()+ " "+
                    postalClient.get(i).getFirstNameClient() + " "+
                    postalClient.get(i).getLastNameClient()+" "+
                    postalClient.get(i).getPatronymicClient()+ " "+
                    postalClient.get(i).getEmailClient()+"\n");
        }
    }

    public void writePostalOffice(List<PostalOffice> postalOffices){
        for(int i = 0; i < postalOffices.size(); i++){
            fileWriterData.print("office : " + postalOffices.get(i).getOfficeNumber() + " "+
                    postalOffices.get(i).getDescription()+"\n");
        }
    }

    public void writePostalPackage(List<PostalPackage> postalPackages){
        for(int i = 0; i < postalPackages.size(); i++){
            fileWriterData.print("package : " + postalPackages.get(i).getTelephoneSender()+ " "+
                    postalPackages.get(i).getNumOfficeRecipient()+ " "+
                    postalPackages.get(i).getFirstNamePackage()+ " "+
                    postalPackages.get(i).getLastNamePackage()+ " "+
                    postalPackages.get(i).getPatronymic()+" "+
                    postalPackages.get(i).getTelephone()+ " "+
                    postalPackages.get(i).getStatus()+ " "+
                    postalPackages.get(i).getDateOfCreate()+ " "+
                    postalPackages.get(i).getDateChangeStatus()+"\n");
        }
    }

    public void writePostalMessage(List<PostalMessage> postalMessages){
        for(int i = 0; i < postalMessages.size(); i++){
            fileWriterMessage.print(postalMessages.get(i).getNumberPackage()+ " "+
                    postalMessages.get(i).getTextMessage()+ " " +
                    postalMessages.get(i).getStatus()+"\n");
        }
    }

    public void close() throws Exception{
        if(fileWriterData != null){
            fileWriterData.close();
        }
        if(fileWriterMessage != null){
            fileWriterMessage.close();
        }
    }
}
