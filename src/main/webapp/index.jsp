<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="utf-8">
    <title>Composer</title>

    <!-- mobile responsive meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- ** Plugins Needed for the Project ** -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="plugins/bootstrap/bootstrap.min.css">
    <!-- themefy-icon -->
    <link rel="stylesheet" href="plugins/themify-icons/themify-icons.css">
    <!-- slick slider -->
    <link rel="stylesheet" href="plugins/slick/slick.css">
    <!-- venobox popup -->
    <link rel="stylesheet" href="plugins/Venobox/venobox.css">
    <!-- aos -->
    <link rel="stylesheet" href="plugins/aos/aos.css">

    <!-- Main Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

    <!--Favicon-->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">

</head>

<body>


<!-- navigation -->
<section class="fixed-top navigation">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light">
            <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- navbar -->
            <div class="collapse navbar-collapse text-center" id="navbar">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link page-scroll" href="#feature">Feature</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="service.html">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link page-scroll" href="#team">Team</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link page-scroll" href="#pricing">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.html">Contact</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</section>
<!-- /navigation -->

<!-- hero area -->
<section class="hero-section hero" data-background="" style="background-image: url(images/hero-area/banner-bg.png);">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center zindex-1">
                <h1 class="mb-3">Take Control of your<br>
                    Music</h1>
                <p class="mb-4">Filter, find, and search for music like you never have before.</p>
                <a href="/Composer/createuser" class="btn btn-secondary btn-lg">explore us</a>
            </div>
        </div>
    </div>
    <!-- background shapes -->
    <div id="scene">
        <img class="img-fluid hero-bg-1 up-down-animation" src="images/background-shape/feature-bg-2.png" alt="">
        <img class="img-fluid hero-bg-2 left-right-animation" src="images/background-shape/seo-ball-1.png" alt="">
        <img class="img-fluid hero-bg-3 left-right-animation" src="images/background-shape/seo-half-cycle.png" alt="">
        <img class="img-fluid hero-bg-4 up-down-animation" src="images/background-shape/green-dot.png" alt="">
        <img class="img-fluid hero-bg-5 left-right-animation" src="images/background-shape/blue-half-cycle.png" alt="">
        <img class="img-fluid hero-bg-6 up-down-animation" src="images/background-shape/seo-ball-1.png" alt="">
        <img class="img-fluid hero-bg-7 left-right-animation" src="images/background-shape/yellow-triangle.png" alt="">
        <img class="img-fluid hero-bg-8 up-down-animation" src="images/background-shape/service-half-cycle.png" alt="">
        <img class="img-fluid hero-bg-9 up-down-animation" src="images/background-shape/team-bg-triangle.png" alt="">
    </div>
</section>

<!-- feature -->
<section class="section feature mb-0" id="feature">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-title">Awesome Features</h2>
                <p class="mb-100">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.<br>Excepteur sint occaecat cupidatat non proident</p>
            </div>
            <!-- feature item -->
            <div class="col-md-6 mb-80">
                <div class="d-flex feature-item">
                    <div>
                        <i class="ti-ruler-pencil feature-icon mr-4"></i>
                    </div>
                    <div>
                        <h4>Awesome Design</h4>
                        <p>Consectetur adipiscing elit donec tempus
                            pellentesque dui.</p>
                    </div>
                </div>
            </div>
            <!-- feature item -->
            <div class="col-md-6 mb-80">
                <div class="d-flex feature-item">
                    <div>
                        <i class="ti-layout-cta-left feature-icon mr-4"></i>
                    </div>
                    <div>
                        <h4>Easy Customize</h4>
                        <p>Consectetur adipiscing elit donec tempus
                            pellentesque dui.</p>
                    </div>
                </div>
            </div>
            <!-- feature item -->
            <div class="col-md-6 mb-80">
                <div class="d-flex feature-item">
                    <div>
                        <i class="ti-split-v-alt feature-icon mr-4"></i>
                    </div>
                    <div>
                        <h4>Bug free Code</h4>
                        <p>Consectetur adipiscing elit donec tempus
                            pellentesque dui.</p>
                    </div>
                </div>
            </div>
            <!-- feature item -->
            <div class="col-md-6 mb-80">
                <div class="d-flex feature-item">
                    <div>
                        <i class="ti-layers-alt feature-icon mr-4"></i>
                    </div>
                    <div>
                        <h4>Organized Layouts</h4>
                        <p>Consectetur adipiscing elit donec tempus
                            pellentesque dui.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <img class="feature-bg-1 up-down-animation" src="images/background-shape/feature-bg-1.png" alt="bg-shape">
    <img class="feature-bg-2 left-right-animation" src="images/background-shape/feature-bg-2.png" alt="bg-shape">
</section>
<!-- /feature -->

<!-- newsletter -->
<section class="newsletter">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Subscribe to our newsletter</h2>
                <p class="mb-5">Receive updates, news and deals</p>
            </div>
            <div class="col-lg-8 col-sm-10 col-12 mx-auto">
                <form action="#">
                    <div class="input-wrapper position-relative">
                        <input type="email" class="newsletter-form" id="newsletter" placeholder="Enter your email">
                        <button type="submit" value="send" class="btn newsletter-btn">subscribe</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- background shapes -->
    <img class="newsletter-bg-shape left-right-animation" src="images/background-shape/seo-ball-2.png" alt="background-shape">
</section>
<!-- /newsletter -->

<!-- footer -->
<footer class="footer-section footer" style="background-image: url(images/backgrounds/footer-bg.png);">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 text-center text-lg-left mb-4 mb-lg-0">
                <!-- logo -->
                <a href="index.html">
                    <img class="img-fluid" src="images/logo.png" alt="logo">
                </a>
            </div>
            <!-- footer menu -->
            <nav class="col-lg-8 align-self-center mb-5">
                <ul class="list-inline text-lg-right text-center footer-menu">
                    <li class="list-inline-item active"><a href="index.html">Home</a></li>
                    <li class="list-inline-item"><a class="page-scroll" href="#feature">Feature</a></li>
                    <li class="list-inline-item"><a href="about.html">About</a></li>
                    <li class="list-inline-item"><a class="page-scroll" href="#team">Team</a></li>
                    <li class="list-inline-item"><a class="page-scroll" href="#pricing">Pricing</a></li>
                    <li class="list-inline-item"><a href="contact.html">Contact</a></li>
                </ul>
            </nav>
            <!-- footer social icon -->
            <nav class="col-12">
                <ul class="list-inline text-lg-right text-center social-icon">
                    <li class="list-inline-item">
                        <a class="facebook" href="#"><i class="ti-facebook"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="twitter" href="#"><i class="ti-twitter-alt"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="linkedin" href="#"><i class="ti-linkedin"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="black" href="#"><i class="ti-github"></i></a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</footer>
<!-- /footer -->

<!-- jQuery -->
<script src="plugins/jQuery/jquery.min.js"></script>
<!-- Bootstrap JS -->
<script src="plugins/bootstrap/bootstrap.min.js"></script>
<!-- slick slider -->
<script src="plugins/slick/slick.min.js"></script>
<!-- venobox -->
<script src="plugins/Venobox/venobox.min.js"></script>
<!-- aos -->
<script src="plugins/aos/aos.js"></script>
<!-- Main Script -->
<script src="js/script.js"></script>

</body>
</html>