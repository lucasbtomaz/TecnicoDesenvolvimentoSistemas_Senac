## Contexto

A empresa Cenaflix deseja ampliar seu ramo de atuação devido ao grande sucesso e agora quer expandir para streaming de áudio, com foco em podcast. Será desenvolvido para isso um módulo para gestão dos cadastros de podcast, a fim de que a equipe do Cenaflix consiga acompanhar e cadastrar as informações da plataforma. A tecnologia mais recomendada nesse caso seria JPA (Java Persistence API), por ser um framework mais seguro, que atualmente tem crescido muito no mercado, e também por ter fácil manutenção.

podcast
└── src
    ├── main
    │   ├── java
    │   │   └── br
    │   │       └── com
    │   │           └── cenaflix
    │   │               ├── podcast
    │   │               │   ├── Main.java            
    │   │               │   ├── Podcast.java      
    │   │               │   └── Usuario.java      
    │   │               ├── persistencia
    │   │               │   ├── JPAUtil.java         
    │   │               │   ├── PodcastDAO.java       
    │   │               │   └── UsuarioDAO.java       
    │   │               ├── service
    │   │               │   ├── PodcastService.java    
    │   │               │   └── UsuarioService.java     
    │   │               └── gui
    │   │                   ├── CadastroPodcast.java 
    │   │                   ├── LoginPanel.java      
    │   │                   └── ListagemPodcast.java  
    │   └── resources
    │       └── META-INF
    │           └── persistence.xml                      
    ├── test
── Test Package
── Outher Source
── Dependencies
── Runtime Dependencies
── Java Dependencies
── Project Files
└── pom.xml
── README.md