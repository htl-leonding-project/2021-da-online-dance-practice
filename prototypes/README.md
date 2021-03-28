# Prototypes

## Streaming Server

- Marktanalyse
  - Streaming Server
    - https://www.pcwelt.de/ratgeber/Alles-was-Sie-fuer-einen-Streaming-Server-brauchen-Fritzbox-NAS-Co.-9697121.html
      - [Readymedia aka miniDLNA](https://www.pcwelt.de/ratgeber/Special-Linux-Handlicher-DLNA-Server-9591951.html)
      - [Mediatomb]()
      - uShare
    - https://opensource.com/article/19/1/basic-live-video-streaming-server
    - https://www.tecmint.com/best-media-server-software-for-linux/
    - https://itsfoss.com/best-linux-media-server/
    
  - Live Streaming Server
    - https://gerpei.de/eigener-live-streaming-server-setup/
  
  - WebRTC-Server
    - https://www.computerweekly.com/de/antwort/Was-ist-ein-WebRTC-Server-und-welche-Funktion-hat-er
    - https://ourcodeworld.com/articles/read/1212/top-5-best-open-source-webrtc-media-server-projects
  
  - [Introducing Video Player Sample (Jahr 2012!)](https://developers.google.com/web/updates/2012/01/Introducing-Video-Player-Sample)

- Beurteilung
  - Readymedia, mediatomb und uShare sind leider nur für das lokale NEtzwerk vorgesehen
  - WebRTC (Web Real-Time Communications)  +wird wohl nicht benötigt
  
- Fazit
  - kein eigener Server notwendig
  - die Videos werden "nur" als Files freigegeben  
  - Verwenden der [clientseitigen WebAPI](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Client-side_web_APIs/Video_and_audio_APIs)
  - eine weitere Option wäre ein Download der benötigten Files (mit verminderter Qualität) -> Vorteil: offline abspielbar
    - ev. im Hintergrund downloaden (local storage)
  














    