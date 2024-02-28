from django.shortcuts import render
from rest_framework.response import Response
from rest_framework.decorators import api_view
from .serializer import ContactSerializer
from .models import Contact


@api_view(['GET'])
def apiOverview(request):
    api_urls = {
        'List': '/contact-list',
        'Detail View' : '/contact-details/<int:id>',
        'Create' : '/contact-create',
        'Update' : '/contact-update/<int:id>',
        'Delete' : '/product-detail/<int:id',
    }
    
    return Response(api_urls)


@api_view(['GET'])
def Showall(request):
    contact = Contact.objects.all()
    serializer = ContactSerializer(contact,many=True)
    return Response(serializer.data)
# Create your views here.
