package com.mqul.impg;

import com.mqul.impg.impl.IMPGService;
import com.mqul.impg.model.PGModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class IMPGController {

    @Autowired IMPGService impgService;

    @CrossOrigin
    @GetMapping("/")
    public @ResponseBody List<PGModel> getPGData(@RequestParam(value="imdbRef") String imdbRef) throws IOException
    {
        return impgService.pullPGData(imdbRef);
    }
}