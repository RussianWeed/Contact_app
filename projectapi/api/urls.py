from django.urls import path
from .import views


urlpatterns = [
    path('',views.apiOverview, name ='apiOverview'),
    path('contact-list/', views.Showall , name = 'contact-list'),
    path('contact-detail/<int:pk>', views.ViewContact , name = 'contact-detail'),
    path('contact-create/', views.CreateContact , name = 'contact-create'),
]