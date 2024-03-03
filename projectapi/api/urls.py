from django.urls import path
from .import views


urlpatterns = [
    path('list/', views.Showall , name = 'contact-list'),
    path('detail/<int:pk>', views.ViewContact , name = 'contact-detail'),
    path('create/', views.CreateContact , name = 'contact-create'),
    path('update/', views.UpdateContact , name = 'contact-update'),
]