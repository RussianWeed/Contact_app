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



@api_view(['GET'])
def ViewContact(request,pk):
    contact = Contact.objects.get(Adhar_card=pk)
    serializer = ContactSerializer(contact,many=False)
    return Response(serializer.data)



@api_view(['POST'])
def CreateContact(request):
    serializer = ContactSerializer(data=request.data)

    if serializer.is_valid():
        serializer.save()

    return Response(serializer.data)

# Create your views here.
