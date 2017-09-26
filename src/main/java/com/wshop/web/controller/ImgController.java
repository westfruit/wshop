/*     */ package com.wshop.web.controller;
/*     */ 
/*     */ import com.wshop.web.model.Base64img;
/*     */ import com.wshop.web.model.UploadResult;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.file.CopyOption;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.core.io.ResourceLoader;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.http.ResponseEntity.HeadersBuilder;
/*     */ import org.springframework.util.Base64Utils;
/*     */ import org.springframework.util.StreamUtils;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.multipart.MultipartHttpServletRequest;
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/upload"})
/*     */ @CrossOrigin(allowedHeaders={"*"}, allowCredentials="true")
/*     */ public class ImgController
/*     */ {
/*  29 */   private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
/*     */   private final ResourceLoader resourceLoader;
/*     */   @Value("${server.upload.path}")
/*     */   private String ROOT;
/*     */   
/*     */   @Autowired
/*     */   public ImgController(ResourceLoader resourceLoader)
/*     */   {
/*  37 */     this.resourceLoader = resourceLoader;
/*     */   }
/*     */   
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/{filename:.+}.{fileprix:.{3,4}}"})
/*     */   @ResponseBody
/*     */   public ResponseEntity<?> getFile(@PathVariable String filename, @PathVariable String fileprix)
/*     */   {
/*     */     try
/*     */     {
/*  47 */       return ResponseEntity.ok(this.resourceLoader.getResource("file:" + Paths.get(this.ROOT, new String[] { filename + "." + fileprix }).toString()));
/*     */     }
/*     */     catch (Exception e) {}
/*  49 */     return ResponseEntity.notFound().build();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/base64/{session}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public UploadResult Base64Upload(@RequestBody Base64img imgdata, @PathVariable String session)
/*     */     throws Exception
/*     */   {
/*  56 */     UploadResult result = new UploadResult();
/*     */     
/*  58 */     String dataPrix = "";
/*  59 */     String data = "";
/*  61 */     if ((imgdata.getImgbase() == null) || ("".equals(imgdata.getImgbase()))) {
/*  62 */       throw new Exception("上传失败，上传图片数据为空");
/*     */     }
/*  64 */     String[] d = imgdata.getImgbase().split("base64,");
/*  65 */     if ((d != null) && (d.length == 2))
/*     */     {
/*  66 */       dataPrix = d[0];
/*  67 */       data = d[1];
/*     */     }
/*     */     else
/*     */     {
/*  69 */       throw new Exception("上传失败，数据不合法");
/*     */     }
/*  72 */     String suffix = "";
/*  73 */     if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
/*  74 */       suffix = ".jpg";
/*  75 */     } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
/*  76 */       suffix = ".ico";
/*  77 */     } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
/*  78 */       suffix = ".gif";
/*  79 */     } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
/*  80 */       suffix = ".png";
/*     */     } else {
/*  82 */       throw new Exception("上传图片格式不合法");
/*     */     }
/*  84 */     String tempFileName = System.currentTimeMillis() + suffix;
/*     */     
/*     */ 
/*     */ 
/*  88 */     byte[] bs = Base64Utils.decodeFromString(data);
/*     */     try
/*     */     {
/*  91 */       logger.info(Paths.get(this.ROOT, new String[] { tempFileName }).toString());
/*  92 */       OutputStream outputStream = new FileOutputStream(new File(Paths.get(this.ROOT, new String[] { tempFileName }).toString()));
/*  93 */       StreamUtils.copy(bs, outputStream);
/*     */     }
/*     */     catch (Exception ee)
/*     */     {
/*  95 */       throw new Exception("上传失败，写入文件失败，" + ee.getMessage());
/*     */     }
/*  98 */     result.setMessage("上传成功");
/*  99 */     result.setImgurl("/upload/" + tempFileName);
/* 100 */     result.setCode("1");
/* 101 */     result.setUrl("/upload/" + tempFileName);
/* 102 */     result.setError(Integer.valueOf(0));
/* 103 */     logger.debug("上传成功");
/*     */     
/* 105 */     return result;
/*     */   }
/*     */   
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, consumes={"multipart/form-data"}, value={"/uploadfile/{session}"})
/*     */   public UploadResult handleFileUpload(@RequestParam("file") MultipartFile file, String session, String dir, HttpServletRequest request)
/*     */   {
/* 113 */     UploadResult result = new UploadResult();
/* 115 */     if (!file.isEmpty()) {
/*     */       try
/*     */       {
/* 118 */         String tempFileName = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'));
/*     */         
/* 120 */         Files.copy(file.getInputStream(), Paths.get(this.ROOT, new String[] { tempFileName }), new CopyOption[0]);
/* 121 */         result.setError(Integer.valueOf(0));
/* 122 */         result.setUrl("/" + tempFileName);
/*     */       }
/*     */       catch (IOException|RuntimeException localIOException) {}
/*     */     }
/* 131 */     return result;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/fileupload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public Object testUploadFile(HttpServletRequest req, MultipartHttpServletRequest multiReq)
/*     */   {
/* 138 */     String uploadFilePath = multiReq.getFile("file").getOriginalFilename();
/* 139 */     System.out.println("uploadFlePath:" + uploadFilePath);
/*     */     
/* 141 */     String uploadFileName = uploadFilePath.substring(uploadFilePath
/* 142 */       .lastIndexOf('\\') + 1, uploadFilePath.indexOf('.'));
/* 143 */     System.out.println("multiReq.getFile()" + uploadFileName);
/*     */     
/* 145 */     String uploadFileSuffix = uploadFilePath.substring(uploadFilePath
/* 146 */       .indexOf('.') + 1, uploadFilePath.length());
/* 147 */     System.out.println("uploadFileSuffix:" + uploadFileSuffix);
/* 148 */     FileOutputStream fos = null;
/* 149 */     FileInputStream fis = null;
/* 150 */     filePath = "/upload/" + uploadFileName + "." + uploadFileSuffix;
/*     */     try
/*     */     {
/* 152 */       fis = (FileInputStream)multiReq.getFile("file").getInputStream();
/*     */       
/* 154 */       fos = new FileOutputStream(new File("D:\\Java\\SpringBoot\\WShop\\src\\main\\resources\\static\\upload\\" + uploadFileName + "." + uploadFileSuffix));
/* 155 */       byte[] temp = new byte[1024];
/* 156 */       int i = fis.read(temp);
/* 157 */       while (i != -1)
/*     */       {
/* 158 */         fos.write(temp, 0, temp.length);
/* 159 */         fos.flush();
/* 160 */         i = fis.read(temp);
/*     */       }
/* 180 */       return filePath;
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       e.printStackTrace();
/*     */     }
/*     */     finally
/*     */     {
/* 165 */       if (fis != null) {
/*     */         try
/*     */         {
/* 167 */           fis.close();
/*     */         }
/*     */         catch (IOException e)
/*     */         {
/* 169 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 172 */       if (fos != null) {
/*     */         try
/*     */         {
/* 174 */           fos.close();
/*     */         }
/*     */         catch (IOException e)
/*     */         {
/* 176 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.controller.ImgController
 * JD-Core Version:    0.7.0.1
 */