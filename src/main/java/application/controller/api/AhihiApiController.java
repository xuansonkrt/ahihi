package application.controller.api;

import application.data.model.Product;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.AhihiDTO;
import application.model.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/ahihi")
public class AhihiApiController {

    @PostMapping("/process")
    public DataApiResult detailMaterial(@Valid @RequestBody AhihiDTO dto){
        DataApiResult result= new DataApiResult();
        try{
            int n= Integer.parseInt(dto.getN());
            int k= Integer.parseInt(dto.getK());
            String tmp[]=dto.getArr().split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String item:tmp) {
                arr.add(Integer.parseInt(item));
            }
            int count=process(n,k,arr);
            result.setSuccess(true);
            result.setMessage("sucess");
            result.setData(count);

        } catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }


        return result;
    }

    @PostMapping("/processCount")
    public DataApiResult processCount(@Valid @RequestBody AhihiDTO dto){
        DataApiResult result= new DataApiResult();
        try{
            int n= Integer.parseInt(dto.getN());
            int k= Integer.parseInt(dto.getK());
            String tmp[]=dto.getArr().split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String item:tmp) {
                arr.add(Integer.parseInt(item));
            }
            int count=processCount(n,k,arr);
            if(arr.size()!=n){
                result.setSuccess(false);
                result.setMessage("arr sai kích thước");
            } else{
                result.setSuccess(true);
                result.setMessage("sucess");
                result.setData(count);
            }


        } catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }


        return result;
    }

    public int process(int n, int k, List<Integer> arr){
        int result=0;
        int e=0, s=0;
        for (int i=0; i<arr.size(); i++){
            if(arr.get(i)==1){
                e++;
            }
            else{
                s++;
            }
        }

        for(int b=0; b<k;b++){
            int temp1=e;
            int temp2=s;
            for(int i=0; b+i*k<=n;i++){
                if(arr.get(i)==1){
                    e--;
                }
                else{
                    s++;
                }
                result=Math.max(result,Math.abs(e-s));
            }
        }
        return  result;
    }


    public int processCount(int n, int k, List<Integer> arr){
        int result=0;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr.get(i)+arr.get(j)==k)
                    result++;
            }
        }
        return  result;
    }
}
