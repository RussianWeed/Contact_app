from django.urls import path
from .import views


urlpatterns = [
    path('contact-list/', views.Showall , name = 'contact-list'),
    path('',views.apiOverview, name ='apiOverview'),
]